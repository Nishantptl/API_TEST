package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ModelDest data[];


    public MyAdapter(List<ModelDest> data) {
        this.data = data.toArray(new ModelDest[0]);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.destName.setText(data[position].getDestinationName());
        holder.history.setText(data[position].getHistory());
        holder.location.setText(data[position].getLocation());
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView thumb;
        TextView destName, history, location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            destName = itemView.findViewById(R.id.DestName);
            history = itemView.findViewById(R.id.History);
            location = itemView.findViewById(R.id.location);
        }
    }



}
