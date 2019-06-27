package com.example.breezapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.breezapp.Fragments.ElectricityFragment;
import com.example.breezapp.Fragments.SignInFragment;
import com.example.breezapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AuthenticationActivity extends AppCompatActivity {
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        setFragment(new SignInFragment());
    }

    /* private void JasonParsa(){

    HttpURLConnection connection = null;
    BufferedReader reader = null;

        try {
        URL url = new URL ("");
        connection = (HttpURLConnection).url.openConnection();
        connection.connect();

        InputStream stream = connection.getInputStream();

        reader = new BufferedReader(new InputStreamReader(stream));

        StringBuffer buffer = new StringBuffer();

        String line="";
        while ((line = reader.readLine())!= null){
            buffer.append(line);
        }

    }catch (MalformedURLException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }finally {
        if(connection != null){
            connection.disconnect();
        }
        try {
            if(reader != null){
                reader.close();}
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
*/
    public void setFragment(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame,f);
        ft.commit();
    }
}
