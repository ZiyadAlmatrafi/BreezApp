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

public class RoomDevicesAdapter extends RecyclerView.Adapter<RoomDevicesAdapter.ViewHolder> {

    // private ArrayList<Thing> devicesList;

    private List<Thing> devicesList;
    Context context;

    public RoomDevicesAdapter(List<Thing> thingList, Context context) {
        this.devicesList = thingList;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomDevicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_card,parent, false);


        return new RoomDevicesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Thing thing = devicesList.get(position);

        holder.textView.setText(thing.getLabel());
        //holder.imageView.setImageResource(mDevice[position].getImg());

    }

    @Override
    public int getItemCount() {
        return devicesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_room);
            imageView = (ImageView)itemView.findViewById(R.id.img_device);

        }
    }

}
