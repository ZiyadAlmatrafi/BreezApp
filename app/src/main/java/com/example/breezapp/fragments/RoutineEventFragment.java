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

/**
 * A simple {@link Fragment} subclass.
 */
public class RoutineEventFragment extends Fragment {

    Button btn_devices;

    public RoutineEventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_routine_event, container, false);

        btn_devices = (Button) v.findViewById(R.id.btn_devices);

        btn_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("RoutineEventFragment","switch to Routine Devices Fragment"+"");


                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame, new RoutineDevicesFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;


    }
}

