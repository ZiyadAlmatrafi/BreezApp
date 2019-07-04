package com.example.breezapp.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.models.Routines;
import com.example.breezapp.R;



import java.util.ArrayList;


public class RoutinesAdapter extends RecyclerView.Adapter<RoutinesAdapter.MyViewHolder>  {

    ArrayList<Routines> arrayList = new ArrayList<>();
    private String context;

    public RoutinesAdapter(ArrayList<Routines> routines){
        this.arrayList=routines;
    }

    @NonNull
    @Override
    public RoutinesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.routines_row_layout,parent,false);
        return new RoutinesAdapter.MyViewHolder(view);
    }


    @Override
    //Binding: The process of preparing a child view to display
    // data corresponding to a position within the adapter.
    public void onBindViewHolder(RoutinesAdapter.MyViewHolder holder, int position) {
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
            mImageView = itemView.findViewById(R.id.routines);

        }
    }
}