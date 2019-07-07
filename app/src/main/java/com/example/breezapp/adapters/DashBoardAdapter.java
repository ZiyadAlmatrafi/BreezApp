package com.example.breezapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.models.Device;
import com.example.breezapp.R;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder> {
    private Device[] mDevice;
    Context context;

    public DashBoardAdapter(Device[] mDevice, Context context) {
        this.mDevice = mDevice;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashborad, null);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(mDevice[position].getName());
        holder.imageView.setImageResource(mDevice[position].getImg());


    }

    @Override
    public int getItemCount() {
        return mDevice.length;
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
