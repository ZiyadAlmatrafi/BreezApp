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

import com.example.breezapp.R;
import com.example.breezapp.Adapters.RoomsAdapter;
import com.example.breezapp.Models.Rooms;
import com.example.breezapp.Models.ThingsList;
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
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Rooms> arrayList = new ArrayList<>();

    int [] im_id={R.drawable.p2,R.drawable.living_room_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {



        View view = inflater.inflate(R.layout.fragment_my_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = (new GridLayoutManager(getContext(),2));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        for (int id : im_id){

            arrayList.add(new Rooms(id));

        }


        adapter= new RoomsAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }


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


}

