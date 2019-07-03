package com.example.breezapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.Activities.AuthenticationActivity;
import com.example.breezapp.Activities.HomeActivity;
import com.example.breezapp.Activities.OnBoardingActivity;
import com.example.breezapp.Fragments.EnterHubCodeFragment;
import com.example.breezapp.R;


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
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }
    // TODO: Rename method, update argument and hook method into UI event
}
