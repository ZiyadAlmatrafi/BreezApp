package com.example.breezapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.breezapp.R;


public class SettingsFragment extends Fragment {
    TextView home_hub;
    TextView account;
    TextView manage_shared;
    TextView manage_third_account;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        home_hub = (TextView) v.findViewById(R.id.home_hub);
        account = (TextView) v.findViewById(R.id.account);
        manage_shared = (TextView) v.findViewById(R.id.manged_shared);
        manage_third_account = (TextView) v.findViewById(R.id.manage_third_account);

        home_hub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HomesHubsFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new AccountFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        manage_shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new ManageSharedDevicesFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        manage_third_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new ManageThirdAccountFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }


}
