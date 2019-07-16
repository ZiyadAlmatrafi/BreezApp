package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.breezapp.fragments.AboutUsFragment;
import com.example.breezapp.fragments.AccountFragment;
import com.example.breezapp.fragments.FeedBackFragment;
import com.example.breezapp.fragments.HomesHubsFragment;
import com.example.breezapp.fragments.ManageSharedDevicesFragment;
import com.example.breezapp.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        Bundle bundle;
        bundle =  getIntent().getExtras();
        String option = bundle.getString("option");

        if (bundle!=null){
            switch (option){
                case "Homes and hubs settings":
                  //  Toast.makeText(getApplicationContext(), "Homes", Toast.LENGTH_SHORT).show();
                    setFragment(new HomesHubsFragment());
                    break;
                case "Account":
                  //  Toast.makeText(getApplicationContext(), "Account", Toast.LENGTH_SHORT).show();
                    setFragment(new AccountFragment());
                    break;
                case "Manage shared devices":
                   // Toast.makeText(getApplicationContext(), "Manage shared devices", Toast.LENGTH_SHORT).show();
                    setFragment(new ManageSharedDevicesFragment());
                    break;

                case "Feedback":
                    //Toast.makeText(getApplicationContext(), "About us", Toast.LENGTH_SHORT).show();
                    setFragment(new FeedBackFragment());
                    break;
                case "About us":
                   // Toast.makeText(getApplicationContext(), "About us", Toast.LENGTH_SHORT).show();
                    setFragment(new AboutUsFragment());
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
