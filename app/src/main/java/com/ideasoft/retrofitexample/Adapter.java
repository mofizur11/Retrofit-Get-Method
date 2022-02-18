package com.ideasoft.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Response> list;

    public Adapter(Context context, List<Response> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userTv.setText(""+list.get(position).getUserId());
        holder.idTv.setText(""+list.get(position).getId());
        holder.titleTv.setText(list.get(position).getTitle());
        holder.bodyTv.setText(list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userTv,idTv,titleTv,bodyTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userTv = itemView.findViewById(R.id.userTv);
            idTv = itemView.findViewById(R.id.idTv);
            titleTv = itemView.findViewById(R.id.titleTv);
            bodyTv = itemView.findViewById(R.id.bodyTv);
        }
    }
}
