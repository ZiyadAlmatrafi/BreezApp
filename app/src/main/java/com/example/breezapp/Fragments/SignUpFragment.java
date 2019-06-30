package com.example.breezapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.breezapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    Button goSignIn;
    Button goSignUp;
    Button doSignUp;
    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sign_up, container, false);
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

        doSignUp = (Button) v.findViewById(R.id.doSignUp);
        doSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Go Login", Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new SignInFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }

}