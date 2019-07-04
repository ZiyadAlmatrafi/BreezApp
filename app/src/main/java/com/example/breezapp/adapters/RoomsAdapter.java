package com.example.breezapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.activities.RoomsActivity;
import com.example.breezapp.R;
import com.example.breezapp.models.Rooms;


import java.util.ArrayList;


public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.MyViewHolder>  {

  //  ArrayList<Rooms> arrayList = new ArrayList<>();
    private Context context;
    private ArrayList<Rooms>  rooms;

  /*  public RoomsAdapter(ArrayList<Rooms> rooms){
        this.arrayList=rooms;
    }
*/
    public RoomsAdapter(ArrayList<Rooms> rooms, Context context) {
        this.context=context;
        this.rooms=rooms;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_row_layout,null);
        return new MyViewHolder(view);
    }


    @Override
    //Binding: The process of preparing a child view to display
    // data corresponding to a position within the adapter.
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // position is The position of a data item within an Adapter.
        holder.mImageView.setImageResource(rooms.get(position).getImg_id());

    }


    @Override
    public int getItemCount() {

        return rooms.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.rooms);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("roomadapter","inside on click");
                    Intent intent = new Intent(context, RoomsActivity.class);
                    intent.putExtra("option", mImageView.getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}