package com.example.breezapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.Activities.HomeActivity;
import com.example.breezapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    Button goSignIn;
    Button goSignUp;
    Button doSignIn;
    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sign_in, container, false);
        goSignIn = (Button) v.findViewById(R.id.sign_in);
        goSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new SignInFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        goSignUp = (Button) v.findViewById(R.id.sign_up);
        goSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new SignUpFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

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