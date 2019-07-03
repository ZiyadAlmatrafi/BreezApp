package com.example.breezapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.breezapp.Adapters.DashBoardAdapter;
import com.example.breezapp.Models.Device;
import com.example.breezapp.R;


public class DashBoardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public DashBoardFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_dash);

        Device d1 = new Device("Lamp",R.drawable.lamp);
        Device d2 = new Device("light bulb",R.drawable.light_bulb);
        Device d3 = new Device("Wall lamp",R.drawable.wall_lamp);
        Device d4 = new Device("Lamp",R.drawable.lamp);
        Device d5 = new Device("light bulb",R.drawable.light_bulb);
        Device d6 = new Device("Wall lamp",R.drawable.wall_lamp);
        Device d7 = new Device("Lamp",R.drawable.lamp);
        Device d8 = new Device("light bulb",R.drawable.light_bulb);
        Device d9 = new Device("Wall lamp",R.drawable.wall_lamp);

        Device device[] = {new Device(d1.getName(),d1.getImg()),
                new Device(d2.getName(),d2.getImg()),
                new Device(d3.getName(),d3.getImg()),
                new Device(d4.getName(),d4.getImg()),
                new Device(d5.getName(),d5.getImg()),
                new Device(d6.getName(),d6.getImg()),
                new Device(d7.getName(),d7.getImg()),
                new Device(d8.getName(),d8.getImg()),
                new Device(d9.getName(),d9.getImg()),

        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DashBoardAdapter mAdapter = new DashBoardAdapter(device,getContext());

        recyclerView.setAdapter(mAdapter);

        return v;
    }


}
