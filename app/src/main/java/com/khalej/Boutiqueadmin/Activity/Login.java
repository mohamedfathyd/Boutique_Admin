package com.khalej.Boutiqueadmin.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.khalej.Boutiqueadmin.model.Apiclient_home;
import com.khalej.Boutiqueadmin.model.apiinterface_home;
import com.khalej.Boutiqueadmin.model.contact_userinfo;
import com.khalej.HelpMe.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    TextInputEditText name,pass;
    AppCompatButton login;
    private List<contact_userinfo> contactList;
    private apiinterface_home apiinterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.textInputEditTextphone);
        pass=findViewById(R.id.textInputEditTextPassword);
        login=findViewById(R.id.appCompatButtonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("200814180")&&pass.getText().toString().equals("101220025")){
                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                }
                else {
                   fetchInfo();
                }

            }
        });

    }
    public void fetchInfo(){


        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_userinfo>> call= apiinterface.getcontacts_login(name.getText().toString(),
                pass.getText().toString() , 2);
        call.enqueue(new Callback<List<contact_userinfo>>() {
            @Override
            public void onResponse(Call<List<contact_userinfo>> call, Response<List<contact_userinfo>> response) {
                if(response.isSuccessful()){

                    contactList = response.body();
                    try {
                        if(contactList.size()==0){
                            Toast.makeText(Login.this,"هناك خطأ فى الهاتف او الرقم السري ",Toast.LENGTH_LONG).show();

                            return ;
                        }
                        else{
                       AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Login.this);
                        dlgAlert.setMessage("تم تسجيل الدخول بنجاح");
                        dlgAlert.setTitle("Boutique");
                        dlgAlert.setPositiveButton("حسنا", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                        startActivity(new Intent(Login.this,Main_Tager.class));}}
                    catch (Exception e){
                        Toast.makeText(Login.this,"هناك خطأ فى الهاتف او الرقم السري ",Toast.LENGTH_LONG).show();


                    }
                }
            }

            @Override
            public void onFailure(Call<List<contact_userinfo>> call, Throwable t) {
                Toast.makeText(Login.this,"هناك خطأ فى الهاتف او الرقم السري",Toast.LENGTH_LONG).show();


            }
        });
    }
}
