package com.example.breezapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.R;
import com.example.breezapp.Models.Rooms;


import java.util.ArrayList;


public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.MyViewHolder>  {

    ArrayList<Rooms> arrayList = new ArrayList<>();
    private String context;

    public RoomsAdapter(ArrayList<Rooms> rooms){
        this.arrayList=rooms;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_row_layout,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    //Binding: The process of preparing a child view to display
    // data corresponding to a position within the adapter.
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // position is The position of a data item within an Adapter.
        holder.mImageView.setImageResource(arrayList.get(position).getImg_id());

    }


    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.rooms);

        }
    }
}