package com.khalej.Turbaadmin.Adapter;

import android.app.Activity;
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
import android.widget.Toast;

import com.khalej.HelpMe.R;
import com.khalej.Turbaadmin.Activity.Order_detail_mandop;
import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_order;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_recervations_withMandop_ extends RecyclerView.Adapter<RecyclerAdapter_recervations_withMandop_.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_order> contactslist;
    apiinterface_home apiinterface;

    public RecyclerAdapter_recervations_withMandop_(Context context, List<contact_order> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recervation__,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        holder.Name.setText("اسم صاحب الطلب :"+contactslist.get(position).getName());
        holder.finish_date.setText("تاريخ :" +contactslist.get(position).getDate());
        holder.price.setText("العنوان :" +contactslist.get(position).getAddress());
       // holder.idd.setText(contactslist.get(position).getId()+"");


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context, Order_detail_mandop.class);
               intent.putExtra("name",contactslist.get(position).getName());
               intent.putExtra("phone",contactslist.get(position).getPhone());
               intent.putExtra("details",contactslist.get(position).getDetails());
               intent.putExtra("address",contactslist.get(position).getAddress());
               intent.putExtra("id",contactslist.get(position).getId());
               intent.putExtra("charge",contactslist.get(position).getCharge());
               intent.putExtra("price",contactslist.get(position).getPrice()+"");
               intent.putExtra("mandop",contactslist.get(position).getMandop());
               context.startActivity(intent);
           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,finish_date,price;
        ImageView delete;

    public MyViewHolder(View itemView) {
        super(itemView);

        Name=(TextView)itemView.findViewById(R.id.txt_fish_title);
        finish_date=(TextView)itemView.findViewById(R.id.txt_title);
        price=(TextView)itemView.findViewById(R.id.txt_);
        delete=itemView.findViewById(R.id.delete);


    }
}

}