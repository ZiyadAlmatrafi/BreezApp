package com.example.breezapp.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.R;
import com.example.breezapp.adapters.RoomsAdapter;
import com.example.breezapp.models.Rooms;
import com.example.breezapp.models.ThingsList;
import com.example.breezapp.rest.RestClient;
import com.example.breezapp.rest.ThingsAPIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyHomeFragment extends Fragment  {

    TextView textView;
    private static final String TAG = MyHomeFragment.class.getSimpleName();
    ThingsAPIService apiService;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_my_home, container, false);


        //apiService = RestClient.getClient().create(ThingsAPIService.class);
        textView = (TextView)view.findViewById(R.id.all_things);
//        fetchThingsList();

        layoutManager = (new GridLayoutManager(getContext(),2));
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Rooms d1 = new Rooms(R.drawable.living_room_icon);
        Rooms d2 = new Rooms(R.drawable.bathroom_icon);

        ArrayList<Rooms> rooms = new ArrayList<Rooms>();

        rooms.add(d1);
        rooms.add(d2);


        RoomsAdapter mAdapter =new RoomsAdapter(rooms,getContext());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

/*
    private void fetchThingsList() {
        Call<ThingsList> call = apiService.fetchThings("android");
        call.enqueue(new Callback<ThingsList>() {
            @Override
            public void onResponse(Call<ThingsList> call, Response<ThingsList> response) {
                Log.d(TAG, "Total number of questions fetched : " + response.body().getThings().size());
                textView.setText(""+response.body().getThings().size());
            }

            @Override
            public void onFailure(Call<ThingsList> call, Throwable t) {
                Log.e(TAG, "Got error : " + t.getLocalizedMessage());
            }
        });
    }

*/
}

