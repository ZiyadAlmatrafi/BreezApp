package com.example.breezapp.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.breezapp.adapters.DashBoardAdapter;
import com.example.breezapp.R;
import com.example.breezapp.models.Thing;
import com.example.breezapp.rest.RestThing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DashBoardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private List<Thing> t;
    private RecyclerView recyclerView;
    private DashBoardAdapter mAdapter;
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);

         recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_dash);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        /*
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_dash);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new DashBoardAdapter(thingList,getContext());
        recyclerView.setAdapter(mAdapter);
*/


        response();


        return v;
}

    public void response()  {

            try {
                Call<List<Thing>> call = RestThing.getInstance().getApi().getInbox();

                // Set up progress before call
                final ProgressDialog progressDoalog;
                progressDoalog = new ProgressDialog(getContext());
                progressDoalog.setMax(100);
                progressDoalog.setMessage("Loading...");
               // progressDoalog.setTitle("ProgressDialog bar example");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                // show it
                progressDoalog.show();

                call.enqueue(new Callback<List<Thing>>() {


                    @Override
                    public void onResponse(Call<List<Thing>> call, Response<List<Thing>> response) {
                      //  Log.e("Response 1", "Response code: " + response.code());

                        if (response.isSuccessful()) {
                            progressDoalog.dismiss();
                            Log.e("Response 2", "Response code: " + response.code());

                            t = response.body();

                            showIt(t);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Thing>> call, Throwable t) {
                        progressDoalog.dismiss();

                        Toast.makeText(getContext(), " Error connecting to the server.. Trying Again...", Toast.LENGTH_SHORT).show();
                       /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Connection lost")
                                .setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {*/

                                        response();
                                 /*   }
                                });*/
                    }
                });

            }catch (Exception e){
                Log.e("Error", ""+e);
                }
    }


    private void showIt(List<Thing> response) {


         mAdapter = new DashBoardAdapter(response,getContext());
         recyclerView.setAdapter(mAdapter);
    }

}
