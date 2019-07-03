package com.example.breezapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_setting);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*
                    switch (getAdapterPosition()){
                        case  0 :
                            Toast.makeText(null, "Go 1", Toast.LENGTH_SHORT).show();
                            break;

                        case 1:
                            Toast.makeText(null, "Go 2", Toast.LENGTH_SHORT).show();


                            break;
                    }
                    */
                }
            });
        }

        @Override
        public void onClick(View view) {


        }

    }
    private void fragmentJump(Setting mItemSelected) {


    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
