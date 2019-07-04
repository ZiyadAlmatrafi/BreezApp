package com.example.breezapp.Fragments;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.Adapters.RoutinesAdapter;
import com.example.breezapp.Models.Routines;
import com.example.breezapp.R;
import com.example.breezapp.Adapters.RoutinesAdapter;
import com.example.breezapp.Models.Routines;


import java.util.ArrayList;


public class RoutineFragment extends Fragment  {

    TextView textView;
    private static final String TAG = RoutineFragment.class.getSimpleName();



    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Routines> arrayList = new ArrayList<>();

    int [] im_id={R.drawable.p2,R.drawable.living_room_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {



        View view = inflater.inflate(R.layout.fragment_routine, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = (new GridLayoutManager(getContext(),2));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        for (int id : im_id){

            arrayList.add(new Routines(id));

        }


        adapter= new RoutinesAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }


}
