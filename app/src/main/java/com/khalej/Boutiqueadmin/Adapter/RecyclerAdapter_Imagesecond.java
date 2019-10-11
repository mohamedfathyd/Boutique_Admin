package com.khalej.Boutiqueadmin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khalej.Boutiqueadmin.Activity.Add_Image;
import com.khalej.Boutiqueadmin.model.apiinterface_home;
import com.khalej.Boutiqueadmin.model.contact_second_home;
import com.khalej.HelpMe.R;

import java.util.List;

public class RecyclerAdapter_Imagesecond extends RecyclerView.Adapter<RecyclerAdapter_Imagesecond.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_second_home> contactslist;
    apiinterface_home apiinterface;

    public RecyclerAdapter_Imagesecond(Context context, List<contact_second_home> contactslist) {
        this.contactslist = contactslist;
        this.context = context;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_delete, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        holder.Name.setText(contactslist.get(position).getname());

        Glide.with(context).load(contactslist.get(position).getImg()).error(R.drawable.logo).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Add_Image.class);
                intent.putExtra("id",contactslist.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactslist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView image;

        ImageView delete;

        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.txt_fish_title);
            image = (ImageView) itemView.findViewById(R.id.imageView3);
            delete = (ImageView) itemView.findViewById(R.id.delete);

        }
    }
}