package com.example.breezapp.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.breezapp.R;
import com.example.breezapp.adapters.DashBoardAdapter;
import com.example.breezapp.adapters.RoomDevicesAdapter;
import com.example.breezapp.models.Thing;
import com.example.breezapp.rest.RestThing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BedRoomFragment extends Fragment {

    private List<Thing> devicesList;
    private RecyclerView RecycleListDevices;
    private RoomDevicesAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bed_room, container, false);

        RecycleListDevices = (RecyclerView) v.findViewById(R.id.RecycleListDevices);
        RecycleListDevices.setLayoutManager(new LinearLayoutManager(getContext()));

        /*
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_dash);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new DashBoardAdapter(thingList,getContext());
        recyclerView.setAdapter(mAdapter);
*/
        response();
        return v;
    }

    public void response() {
        try {
            Call<List<Thing>> call = RestThing.getInstance().getApi().getThings();
            call.enqueue(new Callback<List<Thing>>() {

                @Override
                public void onResponse(Call<List<Thing>> call, Response<List<Thing>> response) {
                    String jsonString;
                    if (response.isSuccessful()) {
                        Log.e("Correct",""+ response.body().getClass());

                        List<Thing> t = response.body();
                        for (int i = 0 ; i<t.size();i++) {
                            Log.e("Correct2", "" + t.get(i).getLabel());
                            showIt(t);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Thing>> call, Throwable t) {
                    Log.e("Not Correct 2","Not Working");

                }
            });

        } catch (Exception e) {
            Log.e("e","ERROOOOOOOOOOOOR");
        }

    }

    private void showIt(List<Thing> response) {
        mAdapter = new RoomDevicesAdapter(response,getContext());
        RecycleListDevices.setAdapter(mAdapter);
    }

}