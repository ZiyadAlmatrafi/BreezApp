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

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder> {
   // private ArrayList<Thing> thingList;

    private List<Thing> thingList;
    Context context;

    public DashBoardAdapter(List<Thing> thingList, Context context) {
        this.thingList = thingList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashborad,parent, false);


        return new DashBoardAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Thing thing = thingList.get(position);

        if (thingList.get(position).getLabel().equals("Breez Office")){

            holder.imageView.setImageResource(R.drawable.idea);
        }

        else if (thingList.get(position).getLabel().equals("Basheer")){

            holder.imageView.setImageResource(R.drawable.switch_on);
        }

        else if (thingList.get(position).getLabel().equals("Yaseen")){

            holder.imageView.setImageResource(R.drawable.thewalllamp);
        }

        else {

            holder.imageView.setImageResource(R.drawable.lamp);
        }

        holder.textView.setText(thing.getLabel());
        //holder.imageView.setImageResource(mDevice[position].getImg());


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
