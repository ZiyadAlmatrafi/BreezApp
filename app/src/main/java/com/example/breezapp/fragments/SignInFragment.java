package com.example.breezapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.breezapp.R;

import androidx.fragment.app.Fragment;

import com.example.breezapp.activities.AuthenticationActivity;
import com.example.breezapp.activities.HomeActivity;
import com.example.breezapp.R;
import com.example.breezapp.models.LoginResponse;
import com.example.breezapp.rest.LoginAPIService;
import com.example.breezapp.rest.RestClient;
import com.example.breezapp.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    Button doSignIn;

    private EditText editTextEmail;
    private EditText editTextPassword;

    LoginAPIService apiService;
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

        String username = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

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
                    LoginResponse loginResponse = response.body();
                    Log.e("responce",response.code()+"");
                    if (response.code() == 200) {
                     Toast.makeText(getContext(), "Go Login", Toast.LENGTH_SHORT).show();
/*
                        SharedPrefManager.getInstance(getActivity())
                                .saveUser(loginResponse.getUser());
                                */
                        Intent i = new Intent(getContext(), HomeActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        startActivity(i);

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


}



