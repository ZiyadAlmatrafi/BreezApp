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
import com.example.breezapp.fragments.NightFragment;
import com.example.breezapp.fragments.RoutineEventFragment;

public class RoutinesActivity extends AppCompatActivity {

    ImageView routineType;

    TextView routineName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_routines);

        routineType = (ImageView)findViewById(R.id.routineType);
        routineName =(TextView)findViewById(R.id.routineName);

        Intent intent = getIntent();
        Bundle bundle =  getIntent().getExtras();
        int option = bundle.getInt("position");
        switch (option){
            case 0:
                routineType.setImageResource(R.drawable.thenight);
                routineName.setText("Night Mode");
                setFragment(new RoutineEventFragment());
                break;
            case 1:
                routineType.setImageResource(R.drawable.sunrise);
                routineName.setText("Morning Mode");
                setFragment(new RoutineEventFragment());
                break;
            case 2:
                routineType.setImageResource(R.drawable.confetti);
                routineName.setText("Party Mode");
                setFragment(new RoutineEventFragment());
                break;
            case 3:
                routineType.setImageResource(R.drawable.popcorn);
                routineName.setText("Movie Mode");
                setFragment(new RoutineEventFragment());
                break;
            case 4:
                routineType.setImageResource(R.drawable.book);
                routineName.setText("Study Mode");
                setFragment(new RoutineEventFragment());
                break;
            case 5:
                routineType.setImageResource(R.drawable.globe);
                routineName.setText("Travel Mode");
                setFragment(new RoutineEventFragment());
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

