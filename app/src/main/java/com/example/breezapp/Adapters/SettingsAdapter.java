package com.example.breezapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.Models.Setting;
import com.example.breezapp.R;

import java.util.ArrayList;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private Setting[] setting;
    //private OnOptionListener mOnOptionListener;

    public SettingsAdapter(Setting[] setting) {
        this.setting = setting;
        //this.mOnOptionListener = onOptionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setting,null);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsAdapter.ViewHolder holder, int position) {
        holder.textView.setText(setting[position].getOption());

    }

    @Override
    public int getItemCount() {

        return setting.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         public TextView textView;
       //  OnOptionListener mOnOptionListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_setting);

        }

        @Override
        public void onClick(View view) {


        }

    }

    public interface OnOptionListener{

    }
}
