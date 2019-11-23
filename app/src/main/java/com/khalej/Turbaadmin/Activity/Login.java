package com.khalej.Turbaadmin.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_userinfo;
import com.khalej.HelpMe.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    TextInputEditText name,pass;
    AppCompatButton login;
    private List<contact_userinfo> contactList;
    Switch swtch;
    int x=2;
    private apiinterface_home apiinterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.textInputEditTextphone);
        pass=findViewById(R.id.textInputEditTextPassword);
        login=findViewById(R.id.appCompatButtonLogin);
        swtch=findViewById(R.id.swtch);
        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    swtch.setText("مندوب");
                    x=3;
                }
                else
                {
                  swtch.setText("تاجر");
                  x=2;
                }
            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().equals("19284500")&&pass.getText().toString().equals("82190045")){
                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                }
                else {
                    login.setClickable(false);
                   fetchInfo();
                }

            }
        });

    }
    public void fetchInfo(){


        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_userinfo>> call= apiinterface.getcontacts_login(name.getText().toString(),
                pass.getText().toString() , x);
        call.enqueue(new Callback<List<contact_userinfo>>() {
            @Override
            public void onResponse(Call<List<contact_userinfo>> call, Response<List<contact_userinfo>> response) {
                if(response.isSuccessful()){

                    contactList = response.body();
                    try {
                        if(contactList.size()==0){
                            Toast.makeText(Login.this,"هناك خطأ فى الهاتف او الرقم السري ",Toast.LENGTH_LONG).show();
                            login.setClickable(true);

                        }
                        else{
                      if(x==2){
                       AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Login.this);
                        dlgAlert.setMessage("تم تسجيل الدخول بنجاح");
                        dlgAlert.setTitle("Torba");
                        dlgAlert.setPositiveButton("حسنا", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();

                        Intent intent =new Intent(Login.this,Main_Tager.class);
                        intent.putExtra("marketid",contactList.get(0).getMarket());
                            intent.putExtra("name",contactList.get(0).getName());
                        startActivity(intent);}
                        else if (x==3){
                            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Login.this);
                            dlgAlert.setMessage("تم تسجيل الدخول بنجاح");
                            dlgAlert.setTitle("Torba");
                            dlgAlert.setPositiveButton("حسنا", null);
                            dlgAlert.setCancelable(true);
                            dlgAlert.create().show();

                            Intent intent =new Intent(Login.this,Main_Mandop.class);
                            intent.putExtra("marketid",contactList.get(0).getMarket());
                            intent.putExtra("name",contactList.get(0).getName());
                            startActivity(intent);}
                        }}
                    catch (Exception e){
                        Toast.makeText(Login.this,"هناك خطأ فى الهاتف او الرقم السري ",Toast.LENGTH_LONG).show();
                        login.setClickable(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<contact_userinfo>> call, Throwable t) {

            }
        });
    }

}
