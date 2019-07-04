package com.example.breezapp.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.activities.HomeActivity;
import com.example.breezapp.activities.MapsActivity;
import com.example.breezapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HubFragment extends Fragment {



    Button hub_button;
    Button map_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hub, container, false);

        hub_button = (Button) v.findViewById(R.id.hub_button);
        map_button = (Button) v.findViewById(R.id.map_button);


        hub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), HomeActivity.class);
                startActivity(i);
            }
        });
/*
        hub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new MyHomeFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });*/
        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);

            }
        });

        return v;
    }





}
