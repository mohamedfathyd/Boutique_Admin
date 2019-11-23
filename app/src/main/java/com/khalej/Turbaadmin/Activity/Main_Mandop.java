package com.khalej.Turbaadmin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.khalej.HelpMe.R;
import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_home;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main_Mandop extends AppCompatActivity {
    Button adddouc,noti;
    apiinterface_home apiinterface;
    private List<contact_home> contactList;
    Intent intent;
    String name;
    int marketid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__mandop);
     intent =getIntent();

     name=intent.getStringExtra("name");
        adddouc=findViewById(R.id.adddouc);
        noti=findViewById(R.id.noti);
        adddouc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main_Mandop.this,Orders_ready.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });


        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo2();
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
                Intent intent=new Intent(Main_Mandop.this,Add_second_category_tager.class);
                intent.putStringArrayListExtra("category_list", arrayList);
                intent.putIntegerArrayListExtra("category_id",arrayList_id);
                intent.putExtra("marketid",marketid);
                intent.putExtra("name",name);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<contact_home>> call, Throwable t) {

            }
        });
    }
}
