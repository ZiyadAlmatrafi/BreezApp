package com.example.breezapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.R;
import com.example.breezapp.models.Thing;

import java.util.List;

public class AllThingsAdapter extends RecyclerView.Adapter<AllThingsAdapter.ViewHolder>{
    private List<Thing> thingList;
    Context context;

    public AllThingsAdapter(List<Thing> thingList, Context context) {
        this.thingList = thingList;
        this.context = context;
    }

    @NonNull
    @Override
    public AllThingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_things_layout,parent, false);


        return new AllThingsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Thing thing = thingList.get(position);

        holder.textView.setText(thing.getLabel());
    }

    @Override
    public int getItemCount() {
        return thingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_dash);
            imageView = (ImageView)itemView.findViewById(R.id.img_dash);
        }
    }
}
