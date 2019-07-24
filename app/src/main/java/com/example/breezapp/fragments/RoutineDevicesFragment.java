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
public class RoutineDevicesFragment extends Fragment {


    Button btn_event;


    public RoutineDevicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_routine_devices, container, false);

        btn_event = (Button) v.findViewById(R.id.btn_event);

        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("RoutineDevicesFragment","switch to Routine Event Fragment"+"");


                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame, new RoutineEventFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;


    }
}
