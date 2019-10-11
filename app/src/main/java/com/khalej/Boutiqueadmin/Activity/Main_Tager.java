package com.khalej.Boutiqueadmin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khalej.Boutiqueadmin.model.Apiclient_home;
import com.khalej.Boutiqueadmin.model.apiinterface_home;
import com.khalej.Boutiqueadmin.model.contact_home;
import com.khalej.HelpMe.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main_Tager extends AppCompatActivity {
    Button adddouc,noti;
    apiinterface_home apiinterface;
    private List<contact_home> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__tager);

        adddouc=findViewById(R.id.adddouc);
        noti=findViewById(R.id.noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Tager.this,Image_inside_category.class));

            }
        });


        adddouc.setOnClickListener(new View.OnClickListener() {
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
                Intent intent=new Intent(Main_Tager.this,Add_second_category.class);
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
