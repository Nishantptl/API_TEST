package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    model data[];

    public myAdapter(model[] data) {
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
        holder.title.setText(data[position].title);
        holder.userid.setText(data[position].userid);
        holder.id.setText(data[position].id);
        holder.body.setText(data[position].body);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView userid, id, title, body;
        public myViewHolder(@NonNull View itemView){
            super(itemView);
            userid = itemView.findViewById(R.id.userid);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }
    }

}
