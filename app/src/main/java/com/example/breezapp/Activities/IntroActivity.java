package com.example.breezapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.breezapp.Fragments.ConnectedHubFragment;
import com.example.breezapp.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_intro);


        addSlide(AppIntroFragment.newInstance("Step 1","Plug to the Electricity", R.drawable.electricity, Color.rgb(0,153,76)));
        addSlide(AppIntroFragment.newInstance("Step p2","Plug the Ethernet",R.drawable.lan, Color.rgb(0,102,204)));

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(this,OnBoardingActivity.class));
        finish();


    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        startActivity(new Intent(this,OnBoardingActivity.class));
        finish();
    }
}
