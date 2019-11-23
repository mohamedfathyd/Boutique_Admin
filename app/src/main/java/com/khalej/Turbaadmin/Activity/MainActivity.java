package com.khalej.Turbaadmin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_home;
import com.khalej.HelpMe.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button add,delete,addannonce,deleteannonce,adddouc,deletedouc,alltager,allmandop,allusers,allqesm,update,today,month,delmandop,deleteannn,
            orders,noti,offer,offer_img,tager,del_tager,reg_tager,offerdelete,deltager,createmandop ,orders_mandop,mandop,updatedouc;
    apiinterface_home apiinterface;
    private List<contact_home> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        delete=findViewById(R.id.delete);
        addannonce=findViewById(R.id.addannonce);
        orders=findViewById(R.id.orders);
        deleteannonce=findViewById(R.id.deleteannonce);
        adddouc=findViewById(R.id.adddouc);
        deletedouc=findViewById(R.id.deletedouc);
        offer=findViewById(R.id.offer);
        deltager=findViewById(R.id.deltager);
        offer_img=findViewById(R.id.offer_img);
        tager=findViewById(R.id.tager);
        del_tager=findViewById(R.id.del_tager);
        orders_mandop=findViewById(R.id.orders_mandop);
        reg_tager=findViewById(R.id.reg_tager);
        offerdelete=findViewById(R.id.offerdelete);
        createmandop=findViewById(R.id.createmandop);
        alltager=findViewById(R.id.alltager);
        allmandop=findViewById(R.id.allmandop);
        today=findViewById(R.id.today);
        allusers=findViewById(R.id.allusers);
        allqesm=findViewById(R.id.allqesm);
        update=findViewById(R.id.update);
        month=findViewById(R.id.month);
        delmandop=findViewById(R.id.delmandop);
        updatedouc=findViewById(R.id.updatedouc);
        deleteannn=findViewById(R.id.deleteannn);
        deleteannn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_inside_annonce_admin.class));
            }
        });
        updatedouc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,update_second_category.class));
            }
        });
        delmandop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_mandop.class));
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Orders_Month.class));

            }
        });
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Orders_By_Day.class));
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,update_category.class));
            }
        });
        allqesm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,All_category.class));

            }
        });
        allusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,All_users.class));

            }
        });
        allmandop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,All_mandop.class));

            }
        });
        alltager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,All_tager.class));

            }
        });
        mandop=findViewById(R.id.mandop);

        mandop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Mandop_orders.class));
            }
        });
        orders_mandop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Orders_mandop.class));
            }
        });
        createmandop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register_mandop.class));
            }
        });
        deltager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_tager.class));
            }
        });
        offerdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_offer.class));
            }
        });
        reg_tager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register_tager.class));
            }
        });
        tager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Tager_orders.class));
            }
        });
        del_tager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RemoveTager_order.class));
            }
        });
        offer_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_offer_image.class));
            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_offer.class));
            }
        });
        noti=findViewById(R.id.noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Image_inside_category.class));

            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Orders.class));

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_category_.class));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_category.class));

            }
        });
     /*   adddouc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo2();
            }
        });*/
        deletedouc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_first_category.class));
            }
        });
        addannonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_annonce.class));
            }
        });
        deleteannonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_annonce.class));
            }
        });
    }
    public void fetchInfo2(){
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_home>> call= apiinterface.getcontacts_first();
        call.enqueue(new Callback<List<contact_home>>() {
            @Override
            public void onResponse(Call<List<contact_home>> call, Response<List<contact_home>> response) {
                contactList = response.body();
                ArrayList<String> arrayList=new ArrayList<>();
                ArrayList<Integer>arrayList_id=new ArrayList<>();
                for (int i=0;i<contactList.size();i++){
                    arrayList.add(contactList.get(i).getname());
                    arrayList_id.add(contactList.get(i).getId());
                }
                Intent intent=new Intent(MainActivity.this,Add_second_category.class);
                intent.putStringArrayListExtra("category_list", arrayList);
                intent.putIntegerArrayListExtra("category_id",arrayList_id);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<contact_home>> call, Throwable t) {

            }
        });
    }
}
