package com.example.breezapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.breezapp.Fragments.ConnectedHubFragment;
import com.example.breezapp.Fragments.ElectricityFragment;
import com.example.breezapp.Fragments.SignInFragment;
import com.example.breezapp.Fragments.SignUpFragment;
import com.example.breezapp.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_authentication);

         setFragment(new SignUpFragment());

    }



    public void setFragment(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame,f);
        ft.commit();
    }
}
