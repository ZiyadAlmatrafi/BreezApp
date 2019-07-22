package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breezapp.R;
import com.example.breezapp.models.Item;
import com.example.breezapp.rest.RestThing;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class ItemActivity extends AppCompatActivity {
    TextView textView;
    List<Item> item;
    ArrayList<Item> itemList;
    Switch aSwitch;
    public String value;
    public String itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        textView = (TextView)findViewById(R.id.item_id);
        aSwitch = (Switch) findViewById(R.id.switch_item);

        Intent intent = getIntent();
        Bundle bundle;
        bundle =  getIntent().getExtras();
        String option = bundle.getString("option");

        response(option);
    }


    public void response(final String name) {


        Call<List<Item>> call = RestThing.getInstance().getApi().getItems();



        call.enqueue(new Callback<List<Item>>() {


            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                //  Log.e("Response 1", "Response code: " + response.code());

                if (response.isSuccessful()) {
                   // progressDoalog.dismiss();
                   // Log.e("Response 2", "Response code: " + response.body().size());
                    Item ite;
                    item = response.body();
                        for(int i = 0 ; i <item.size();i++){
                           // Log.e("Response 2555", "Response code: " +item.get(i).getName() );
                            if(name.equalsIgnoreCase(item.get(i).getName() )){
                              //  Log.e("Item Activity", "Response: " +item.get(i).getLink() );
                                textView.setText(item.get(i).getLabel());

                                ite = new Item();
                                ite.setName(item.get(i).getName());
                                ite.setLink(item.get(i).getLink());
                                ite.setState(item.get(i).getState());
                                ite.setType(item.get(i).getType());
                                ite.setCategory(item.get(i).getCategory());
                                ite.setLabel(item.get(i).getLabel());

                               // itemList.add(ite);
                                itemName =item.get(i).getName();

                                if (aSwitch.isChecked()){
                                    value = "ON";
                                }else {
                                    value = "OFF";
                                }
                                post(itemName,value);

                            }

                            }





                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
             //   progressDoalog.dismiss();

                Toast.makeText(getApplicationContext(), " Error connecting to the server.. Try Again later", Toast.LENGTH_SHORT).show();


               // response();

            }
        });
    }
    public void post(String itemname, String state){
        Call<Void> voidCall = RestThing.getInstance().getApi().postItem(itemname,state);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                 Log.e("Response POST", "Response code: " + response.code());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Response POST", "Error");

            }
        });

    }

}
