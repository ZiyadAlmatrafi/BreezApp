package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.breezapp.R;
import com.example.breezapp.fragments.AccountFragment;
import com.example.breezapp.fragments.HomesHubsFragment;
import com.example.breezapp.fragments.ManageSharedDevicesFragment;
import com.example.breezapp.fragments.ManageThirdAccountFragment;
import com.example.breezapp.fragments.MorningFragment;
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
                   // Toast.makeText(getApplicationContext(), "Homes", Toast.LENGTH_SHORT).show();
                    setFragment(new MorningFragment());
                    break;
                case "Account":
                   // Toast.makeText(getApplicationContext(), "Account", Toast.LENGTH_SHORT).show();
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
