package com.example.breezapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.adapters.RoutinesAdapter;
import com.example.breezapp.models.Routines;
import com.example.breezapp.R;


import java.util.ArrayList;


public class RoutineFragment extends Fragment  {

    TextView textView;
    private static final String TAG = RoutineFragment.class.getSimpleName();



    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Routines> arrayList = new ArrayList<>();

   //int [] im_id={R.drawable.morning,R.drawable.night};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {



      /*  View view = inflater.inflate(R.layout.fragment_routine, container, false);
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
    }*/




        View view = inflater.inflate(R.layout.fragment_routine, container, false);
        layoutManager = (new GridLayoutManager(getContext(),2));

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Routines d1 = new Routines(R.drawable.morning);
        Routines d2 = new Routines(R.drawable.night);

        ArrayList<Routines> routines = new ArrayList<Routines>();

        routines.add(d1);
        routines.add(d2);


        RoutinesAdapter mAdapter =new RoutinesAdapter(routines,getContext());
        //adapter= new RoomsAdapter(arrayList);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

}
