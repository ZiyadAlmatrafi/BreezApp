package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breezapp.R;
import com.example.breezapp.adapters.DashBoardAdapter;
import com.example.breezapp.adapters.RoomDevicesAdapter;
import com.example.breezapp.models.Rooms;
import com.example.breezapp.models.Thing;
import com.example.breezapp.rest.RestThing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomActivity extends AppCompatActivity {
    ImageView roomType;
    RecyclerView recyclerView;
    TextView textView;
    String location= "";
    private List<Thing> t;
    private RoomDevicesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomType =(ImageView)findViewById(R.id.RoomType);
        textView =(TextView)findViewById(R.id.RoomName);
        recyclerView = (RecyclerView)findViewById(R.id.RecycleListDevices);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Intent intent = getIntent();
        Bundle bundle;
        bundle =  getIntent().getExtras();
        int option = bundle.getInt("position");


        switch (option){

            case 0:
                roomType.setImageResource(R.drawable.bedroom);
                textView.setText("Bedroom");
                response();
                break;

            case 1:
                roomType.setImageResource(R.drawable.livingroom);
                textView.setText("Living Room");
                response();
                break;

            case 2:
                roomType.setImageResource(R.drawable.bathtub);
                textView.setText("Bathroom");
                response();
                break;

            case 3:
                roomType.setImageResource(R.drawable.kitchen);
                textView.setText("Kitchen");
                response();
                break;

            case 4:
                roomType.setImageResource(R.drawable.studydesk);
                textView.setText("Study Room");
                response();
                break;

            case 5:
                roomType.setImageResource(R.drawable.stock);
                textView.setText("Store");
                response();
                break;
        }

    }

    public void response()  {

        try {
            Call<List<Thing>> call = RestThing.getInstance().getApi().getThings();

            call.enqueue(new Callback<List<Thing>>() {


                @Override
                public void onResponse(Call<List<Thing>> call, Response<List<Thing>> response) {
                    //  Log.e("Response 1", "Response code: " + response.code());

                    if (response.isSuccessful()) {
                        Log.e("Response 2", "Response code: " + response.code());

                        t = response.body();

                        showIt(t);
                    }
                }

                @Override
                public void onFailure(Call<List<Thing>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), " Error connecting to the server.. Trying Again...", Toast.LENGTH_SHORT).show();
                    // Log.e("Not Correct ", "Not Working");
                    response();

                }
            });

        }catch (Exception e){
            Log.e("Error", ""+e);
        }

    }


    private void showIt(List<Thing> response) {

        mAdapter = new RoomDevicesAdapter(response,getApplicationContext());
        recyclerView.setAdapter(mAdapter);
    }


}
