package com.example.breezapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.breezapp.Fragments.DashBoardFragment;
import com.example.breezapp.Fragments.ElectricityFragment;
import com.example.breezapp.Fragments.MyHomeFragment;
import com.example.breezapp.Fragments.NotificationFragment;
import com.example.breezapp.Fragments.RoutineFragment;
import com.example.breezapp.Fragments.SettingsFragment;
import com.example.breezapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        setFragment(new MyHomeFragment());
      BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.my_home:
                        setFragment(new MyHomeFragment());
                        break;
                    case R.id.routine:
                        setFragment(new RoutineFragment());
                        break;
                    case R.id.dashboard:
                        setFragment(new DashBoardFragment());
                        break;
                    case R.id.settings:
                        setFragment(new SettingsFragment());
                        break;
                    case R.id.notifications:
                        setFragment(new NotificationFragment());
                        break;
                }
                return true;
            }
        });

    }
    public void setFragment(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame,f);
       // ft.addToBackStack(null);
        ft.commit();
    }
}
