package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.breezapp.R;
import com.example.breezapp.fragments.NightFragment;

public class RoutinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);


        Bundle bundle;
        bundle =  getIntent().getExtras();
        String option = bundle.getString("option");

        if (bundle!=null){
            switch (option){
                case "Homes and hubs settings":
                    break;
                case "Account":
                    setFragment(new NightFragment());
                    break;

            }
        }



    }
    public void setFragment(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame,f);
        ft.commit();
    }
}
