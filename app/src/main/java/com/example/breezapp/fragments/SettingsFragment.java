package com.example.breezapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.breezapp.adapters.SettingsAdapter;
import com.example.breezapp.models.Setting;
import com.example.breezapp.R;


public class SettingsFragment extends Fragment  {
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

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        Setting s1 = new Setting("Homes and hubs settings");
        Setting s2 = new Setting("Account");
        Setting s3 = new Setting("Manage shared devices");
       // Setting s4 = new Setting("Manage third party accounts");
        Setting s5 = new Setting("Supported devices");
        //Setting s6 = new Setting("Connect devices guide");
        Setting s7 = new Setting("Feedback");
        Setting s8 = new Setting("About us");



        Setting setting[] = {new Setting(s1.getOption()),
                new Setting(s2.getOption()),
                new Setting(s3.getOption()),
          //      new Setting(s4.getOption()),
                new Setting(s5.getOption()),
            //    new Setting(s6.getOption()),
                new Setting(s7.getOption()),
                new Setting(s8.getOption())

        };

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SettingsAdapter mAdapter = new SettingsAdapter(setting,getContext());

        recyclerView.setAdapter(mAdapter);


        return v;

    }



}
