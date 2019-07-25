package com.example.breezapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.breezapp.R;
import com.example.breezapp.activities.HomeActivity;
import com.example.breezapp.models.LoginResponse;
import com.example.breezapp.models.User;
import com.example.breezapp.rest.RestClient;
import com.example.breezapp.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    Button doSignIn;
    private Context context;
    private EditText editTextEmail;
    private EditText editTextPassword;

   // APIService apiService;
    private static final String TAG = SignInFragment.class.getSimpleName();

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sign_in, container, false);


        editTextEmail = v.findViewById(R.id.emailId);
        editTextPassword = v.findViewById(R.id.inputPassword);



        doSignIn = (Button) v.findViewById(R.id.doSignIn);
        doSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                userLogin();

            }
        });
        return v;
    }

    private void userLogin() {

        final String username = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
            return;
        }


        Call<LoginResponse> call = RestClient
                .getInstance().getApi().userLogin(username, password);

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                  // LoginResponse loginResponse = response.body();

                    Log.e("responce",response.code()+"");
                   // Log.e("responce",response.body()+"");
                    if (response.code() == 200) {
                        User user = new User(username,password);
                        SharedPrefManager.getInstance(getContext())
                                .saveUser(user);

                        Intent i = new Intent(getContext(), HomeActivity.class);
                       // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        startActivity(i);
                        getActivity().finish();

                  }else {
                       Toast.makeText(getContext(), "Wrong pass or username", Toast.LENGTH_LONG).show();

                  }

                }
                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Log.e(TAG, "Got error : " + t.getLocalizedMessage());
                }
            });

}
    private void hideKeyboardFrom(View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

}



