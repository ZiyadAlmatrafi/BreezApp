package com.example.breezapp.Adapters;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breezapp.Activities.HomeActivity;
import com.example.breezapp.Activities.SettingsActivity;
import com.example.breezapp.Fragments.SettingsFragment;
import com.example.breezapp.Models.Setting;
import com.example.breezapp.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.startActivity;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private Setting[] mSetting;
    Context context;


    // private OnOptionListener mOnOptionListener;


    public SettingsAdapter(Setting[] setting, Context context) {
        this.mSetting = setting;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setting, null);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsAdapter.ViewHolder holder, int position) {

        holder.textView.setText(mSetting[position].getOption());


    }

    @Override
    public int getItemCount() {

        return mSetting.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView1;
        //OnOptionListener onOptionListener;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_setting);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                        Intent intent = new Intent(context, SettingsActivity.class);
                        intent.putExtra("option", textView.getText());
                        context.startActivity(intent);


                }
            });
        }

    }

}
