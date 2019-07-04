package com.example.breezapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.breezapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyHomeFragment extends Fragment  {



    ImageView bed_room , living_room , bath_room , kitchen , store_room , study_room;


    public MyHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_home, container, false);



        return v;
    }


}