package com.khalej.Turbaadmin.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.khalej.HelpMe.R;
import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Order_detail_Ready extends AppCompatActivity {
    TextView name,phone,address,details,getfinal,charge,price;
    Intent intent;
    Toolbar toolbar;
    private apiinterface_home apiinterface;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    int id,idd;
    ProgressDialog progressDialog;

    String Mandopname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_ready);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        this.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );


        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        getfinal=findViewById(R.id.getfinal);
        details=findViewById(R.id.details);
        charge=findViewById(R.id.charge);
        price=findViewById(R.id.price);
        intent=getIntent();
        charge.setText(intent.getStringExtra("charge"));
        name.setText(intent.getStringExtra("name"));
        phone.setText(intent.getStringExtra("phone"));
        address.setText(intent.getStringExtra("address"));
        details.setText(intent.getStringExtra("details"));
        price.setText(intent.getStringExtra("price"));
        Mandopname=intent.getStringExtra("mandop");
        idd=intent.getIntExtra("id",0);
        getfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Order_detail_Ready.this)
                        .setTitle("Torba App")
                        .setMessage("هل انت متأكد ان هذا الطلب يمكنك توصيله لانه عند الضغط بنعم سيصبح هذا الطلب مرتبط بك وعليك توصيله للزبون  ؟")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                fetchInfo();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });


    }
    public void fetchInfo() {
        progressDialog = ProgressDialog.show(Order_detail_Ready.this, "جارى التنفيذ", "Please wait...", false, false);
        progressDialog.show();


        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = null;
        call=apiinterface.mandop_add_order_tohim(idd,Mandopname);



        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Order_detail_Ready.this);
                dlgAlert.setMessage("تم  ربط الطلب بك");
                dlgAlert.setTitle("Torba App");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                startActivity(new Intent(Order_detail_Ready.this,Main_Mandop.class));
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }
}
