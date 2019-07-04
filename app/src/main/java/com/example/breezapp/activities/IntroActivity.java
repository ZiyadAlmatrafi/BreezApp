package com.example.breezapp.activities;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.breezapp.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_intro);


        addSlide(AppIntroFragment.newInstance("Step 1","Plug to the Electricity", R.drawable.electricity, Color.rgb(18, 167, 156)));
        addSlide(AppIntroFragment.newInstance("Step 2","Plug the Ethernet",R.drawable.ethernet, Color.rgb(18, 167, 156)));
        addSlide(AppIntroFragment.newInstance("Good Work","You Are Ready",R.drawable.breez_logo_white, Color.rgb(18, 167, 156)));

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
