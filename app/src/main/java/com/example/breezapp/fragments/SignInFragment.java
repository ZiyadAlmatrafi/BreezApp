package com.example.breezapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.breezapp.R;

import androidx.fragment.app.Fragment;

import com.example.breezapp.activities.HomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    private static final String TAG = "fragment_sign_in";
    Button doSignIn;
    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sign_in, container, false);

        doSignIn = (Button) v.findViewById(R.id.doSignIn);
        doSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), HomeActivity.class);
                startActivity(i);
            }
        });
        return v;
    }
}