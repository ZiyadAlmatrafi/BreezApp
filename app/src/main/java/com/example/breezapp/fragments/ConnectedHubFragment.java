package com.example.breezapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.breezapp.R;


public class ConnectedHubFragment extends Fragment {

Button foundButton;
Button notFoundButton;
TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_connected_hub, container, false);
        textView =(TextView)v.findViewById(R.id.con_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubFoundFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        /*foundButton = (Button) v.findViewById(R.id.foundButton);
        notFoundButton = (Button) v.findViewById(R.id.notFoundButton);
        foundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubFoundFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        notFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubNotFoundFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });*/

        return v;
    }
}
