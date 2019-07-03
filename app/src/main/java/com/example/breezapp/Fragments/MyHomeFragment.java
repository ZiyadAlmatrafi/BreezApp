package com.example.breezapp.Fragments;


import android.content.Intent;
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

        bed_room = (ImageView) v.findViewById(R.id.bed_room);
        bed_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new BedRoomFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        living_room = (ImageView) v.findViewById(R.id.living_room);
        living_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new LivingRoomFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        bath_room = (ImageView) v.findViewById(R.id.bath_room);
        bath_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new BathRoomFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        kitchen = (ImageView) v.findViewById(R.id.kitchen);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new KitchenFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        store_room = (ImageView) v.findViewById(R.id.store_room);
        store_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new StoreFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        study_room = (ImageView) v.findViewById(R.id.study_room);
        study_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new StudyRoomFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }


}