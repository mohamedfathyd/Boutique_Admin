package com.khalej.Boutiqueadmin.Adapter;

import android.app.Activity;
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
import android.widget.Toast;

import com.khalej.Boutiqueadmin.model.Apiclient_home;
import com.khalej.Boutiqueadmin.model.apiinterface_home;
import com.khalej.Boutiqueadmin.model.contact_tager;
import com.khalej.HelpMe.R;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_alltager_del extends RecyclerView.Adapter<RecyclerAdapter_alltager_del.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_tager> contactslist;
     apiinterface_home apiinterface;
    public RecyclerAdapter_alltager_del(Context context, List<contact_tager> contactslist){
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


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new AlertDialog.Builder(context)
                       .setTitle("Boutique App")
                       .setMessage("هل انت متأكد انك تريد المسح ؟")
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                           public void onClick(DialogInterface dialog, int whichButton) {
                               int id=contactslist.get(position).getId();
                               fetchInfo(id);
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
        TextView Name,address,phone;
        ImageView image;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.name);
        address=(TextView)itemView.findViewById(R.id.address);
        phone=(TextView)itemView.findViewById(R.id.phone);


    }
}

    public void fetchInfo(int id) {

        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = null;
        call=apiinterface.delete_first(id);



        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Toast.makeText(context,"تم المسح",Toast.LENGTH_LONG).show();
                ((Activity)context).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }
}