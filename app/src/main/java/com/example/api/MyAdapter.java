package com.example.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ModelDest data[];

    public MyAdapter(Context context, ArrayList<ModelDest> data) {
        this.context = context;
        this.data = data.toArray(new ModelDest[0]);
    }

    public MyAdapter() {
//        this.data = data;
//        this.context=context;
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
//        holder.image.setImageURI(data[position].getThumb());
        ViewTarget<ImageView, Drawable> g = Glide.with(context).load(data[position].getThumb()).into(holder.image);
        //holder.image.setImageBitmap(image);
        Log.d("image", String.valueOf(g));

//        holder.list.setAdapter();
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView thumb;
        TextView destName, history, location;
        ImageView image;
        RecyclerView list;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            destName = itemView.findViewById(R.id.DestName);
            history = itemView.findViewById(R.id.History);
            location = itemView.findViewById(R.id.location);
            image = itemView.findViewById(R.id.imageView);
            list = itemView.findViewById(R.id.list);

//            Glide.with(context).load(data[]).into(image);

        }
    }



}
