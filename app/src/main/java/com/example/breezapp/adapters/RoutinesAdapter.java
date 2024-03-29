package com.example.breezapp.adapters;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.breezapp.activities.RoutinesActivity;
import com.example.breezapp.models.Routines;
import com.example.breezapp.R;
import java.util.ArrayList;
public class RoutinesAdapter extends RecyclerView.Adapter<RoutinesAdapter.MyViewHolder>  {

    private Context context;
    private ArrayList<Routines>  routines;

    public RoutinesAdapter(ArrayList<Routines> routines, Context context) {
        this.context=context;
        this.routines=routines;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.routines_row_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mImageView.setImageResource(routines.get(position).getImg_id());
    }

    @Override
    public int getItemCount() {
        return routines.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView routineType;

        public MyViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.routines);
            mImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Log.e("routineadapter","inside on click");
                    Intent intent = new Intent(context, RoutinesActivity.class);
                    intent.putExtra("option", mImageView.getId());
                    Log.e("routineadapter","is"+ mImageView.getId());
                    intent.putExtra("position", getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}

