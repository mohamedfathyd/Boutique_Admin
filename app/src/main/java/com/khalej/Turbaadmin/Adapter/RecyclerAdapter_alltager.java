package com.khalej.Turbaadmin.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_tager;
import com.khalej.HelpMe.R;

import java.util.List;

public class RecyclerAdapter_alltager extends RecyclerView.Adapter<RecyclerAdapter_alltager.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_tager> contactslist;
     apiinterface_home apiinterface;
    public RecyclerAdapter_alltager(Context context, List<contact_tager> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tager,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


    holder.Name.setText(contactslist.get(position).getName());
        holder.address.setText(contactslist.get(position).getAddress());
        holder.phone.setText(contactslist.get(position).getPhone());
        holder.m.setText("اسم المتجر :"+contactslist.get(position).getMatgar_name());
        holder.n.setText( "السجل التجاري :" + contactslist.get(position).getSegel_togary());


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new AlertDialog.Builder(context)
                       .setTitle("Torba App")
                       .setMessage( contactslist.get(position).getPhone()+"\n"+"انه يريد الانضام ألينا كتاجر تواصل معه فى اسرع وقت ")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                           public void onClick(DialogInterface dialog, int whichButton) {

                           }})
                       .setNegativeButton(android.R.string.no, null).show();
           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,address,phone,m,n;
        ImageView image;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.name);
        address=(TextView)itemView.findViewById(R.id.address);
        phone=(TextView)itemView.findViewById(R.id.phone);
        m=itemView.findViewById(R.id.m);
        n=itemView.findViewById(R.id.n);


    }
}

}