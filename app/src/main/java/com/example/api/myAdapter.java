package com.example.api;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    Category data[];

    public myAdapter(Category data[]) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.id.setText(data[position].id);
        holder.name.setText(data[position].name);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView id, name;
        ImageView image;
        public myViewHolder(@NonNull View itemView){
            super(itemView);
            name =itemView.findViewById(R.id.title);

            id = itemView.findViewById(R.id.Id);
//            image = itemView.findViewById(R.id.imageView);


        }
    }

}
