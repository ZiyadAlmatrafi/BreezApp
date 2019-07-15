package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.breezapp.R;
import com.example.breezapp.models.Rooms;

public class RoomActivity extends AppCompatActivity {
    ImageView roomType;
    RecyclerView recyclerView;
    TextView textView;
    String location= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);


        roomType = (ImageView)findViewById(R.id.RoomType);
        textView =(TextView)findViewById(R.id.RoomName);
        recyclerView = (RecyclerView)findViewById(R.id.RecycleListDevices);

        Intent intent = getIntent();
        Bundle bundle;
        bundle =  getIntent().getExtras();
        int option = bundle.getInt("position");

        switch (option){

            case 0:
                roomType.setImageResource(R.drawable.bedroom);
                textView.setText("Bedroom");

                break;
            case 1:
                roomType.setImageResource(R.drawable.livingroom);
                textView.setText("Living Room");
                break;

            case 2:
                roomType.setImageResource(R.drawable.bathtub);
                textView.setText("Bathroom");
                break;

            case 3:
                roomType.setImageResource(R.drawable.kitchen);
                textView.setText("Kitchen");
                break;

            case 4:
                roomType.setImageResource(R.drawable.studydesk);
                textView.setText("Study Room");
                break;

            case 5:
                roomType.setImageResource(R.drawable.stock);
                textView.setText("Store");
                break;
        }
    }

    public void setFragment(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame,f);
        ft.commit();
    }

}
