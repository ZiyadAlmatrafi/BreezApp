package com.example.breezapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.R;


public class HubNotFoundFragment extends Fragment {
    Button notFound;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hub_not_found, container, false);

        notFound = (Button) v.findViewById(R.id.notFoundButton);
        notFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame, new ConnectedHubFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;


    }
}
