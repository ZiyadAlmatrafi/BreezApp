package com.example.breezapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.R;


public class NightFragment extends Fragment {

    Button btn_devices;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_night, container, false);

        btn_devices = (Button) v.findViewById(R.id.btn_devices);

        btn_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("response","Move to NightFragment"+"");


                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame, new NightDeviceFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;


    }
}

