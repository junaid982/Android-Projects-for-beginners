package com.example.simplerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContact;
    public RecyclerContactAdapter(Context context ,ArrayList<ContactModel> arrContact ) {
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public RecyclerContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row , parent , false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerContactAdapter.ViewHolder holder, int position) {
        holder.iconImg.setImageResource(arrContact.get(position).img);
        holder.textName.setText(arrContact.get(position).name);
        holder.textContact.setText(arrContact.get(position).number);


    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName , textContact;
        ImageView iconImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textName);
            textContact = itemView.findViewById(R.id.textContact);
            iconImg = itemView.findViewById(R.id.iconImg);

        }
    }
}
