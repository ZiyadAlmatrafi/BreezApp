package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breezapp.R;
import com.example.breezapp.models.Item;
import com.example.breezapp.rest.RestThing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemActivity extends AppCompatActivity {
    TextView textView;
    Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        textView = (TextView)findViewById(R.id.item_id);

        Intent intent = getIntent();
        Bundle bundle;
        bundle =  getIntent().getExtras();
        String option = bundle.getString("option");
        textView.setText(option);

        response(option);
    }


    public void response(String name) {


        Call<List<Item>> call = RestThing.getInstance().getApi().getItems();

        // Set up progress before call
        /*final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(getApplicationContext());
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading...");
        // progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();*/

        call.enqueue(new Callback<List<Item>>() {


            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                //  Log.e("Response 1", "Response code: " + response.code());

                if (response.isSuccessful()) {
                   // progressDoalog.dismiss();
                    Log.e("Response 2", "Response code: " + response.body().size());

                    //  t = response.body();


                    // showIt(t);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
               // progressDoalog.dismiss();

                Toast.makeText(getApplicationContext(), " Error connecting to the server.. Trying Again...", Toast.LENGTH_SHORT).show();


               // response();

            }
        });
    }
}
