package com.example.breezapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breezapp.R;
import com.example.breezapp.models.Item;
import com.example.breezapp.rest.APIService;
import com.example.breezapp.rest.RestItem;
import com.example.breezapp.rest.RestThing;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
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
        //textView.setText("Switch");
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

                if (response.isSuccessful()) {

                    item = response.body();
                        for(int i = 0 ; i <item.size();i++){
                            if(name.equalsIgnoreCase(item.get(i).getName() )){
                                textView.setText(item.get(i).getLabel());


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

                Toast.makeText(getApplicationContext(), " Error connecting to the server.. Try Again later", Toast.LENGTH_SHORT).show();



            }
        });
    }

    public void post(String itemName,String state){
        // Need to put this methoed in AsycnTask in future
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),state);
        Call<ResponseBody> voidCall = RestItem.getInstance().getApi().lastTest(itemName,requestBody);

        try {
            Response<ResponseBody> response = voidCall.execute();
            if (response.isSuccessful()){
                int strRes = response.code();
                 Log.e("Response 2", "Response code: " +strRes);


            }

        } catch (Exception e){
            Log.e("Response 2", "Response code: " +e);
        }


    }

}
