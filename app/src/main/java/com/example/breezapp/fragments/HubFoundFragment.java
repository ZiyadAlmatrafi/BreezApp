package com.example.breezapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.R;
import com.example.breezapp.activities.AuthenticationActivity;
import com.example.breezapp.activities.HomeActivity;


public class HubFoundFragment extends Fragment {
    Button enterCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hub_found, container, false);

        enterCode = (Button) v.findViewById(R.id.enter_code);
        enterCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AuthenticationActivity.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        return v;
    }
    // TODO: Rename method, update argument and hook method into UI event
}
