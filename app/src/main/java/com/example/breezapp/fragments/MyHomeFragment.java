package com.example.breezapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.R;
import com.example.breezapp.activities.ThingActivity;
import com.example.breezapp.adapters.RoomsAdapter;
import com.example.breezapp.models.Rooms;
import com.example.breezapp.models.Thing;
import com.example.breezapp.rest.RestThing;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyHomeFragment extends Fragment {

    TextView all_things_total;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_my_home, container, false);

        all_things_total = (TextView)view.findViewById(R.id.all_things_total);
        fetchAllThings();

        layoutManager = (new GridLayoutManager(getContext(),2));
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Rooms d1 = new Rooms(R.drawable.bedroom,"9qDrllk0");
        Rooms d2 = new Rooms(R.drawable.livingroom,"NqWOoHRY");
        Rooms d3 = new Rooms(R.drawable.bathtub,"ucl6pDuO");
        Rooms d4 = new Rooms(R.drawable.kitchen,"yDe4ehx7");
        Rooms d5 = new Rooms(R.drawable.studydesk,"");
        Rooms d6 = new Rooms(R.drawable.stock,"");

        ArrayList<Rooms> rooms = new ArrayList<Rooms>();
        rooms.add(d1);
        rooms.add(d2);
        rooms.add(d3);
        rooms.add(d4);
        rooms.add(d5);
        rooms.add(d6);

        RoomsAdapter mAdapter =new RoomsAdapter(rooms,getContext());
        recyclerView.setAdapter(mAdapter);

        imageView = (ImageView) view.findViewById(R.id.my_home_bar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ThingActivity.class);
                startActivity(intent);
            }
        });
        return view;

}


    private void fetchAllThings() {try {


        Call<List<Thing>> call = RestThing.getInstance().getApi().getThings();

        call.enqueue(new Callback<List<Thing>>() {

            @Override
            public void onResponse(Call<List<Thing>> call, Response<List<Thing>> response) {

                if (response.isSuccessful()) {

                    Log.e("response",response.code()+"");

                    Log.e("response",""+response.body().size());

                    all_things_total.setText(""+response.body().size());
                }
            }

            @Override
            public void onFailure(Call<List<Thing>> call, Throwable t) {
                Log.e("Not Correct 2","Not Working");

            }
        });


    } catch (Exception e) {
        Log.e("e","ERROR");
    }

    }

}