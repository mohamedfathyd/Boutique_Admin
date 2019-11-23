package com.khalej.Turbaadmin.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_home;
import com.khalej.HelpMe.R;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_tager extends AppCompatActivity {
    TextInputLayout textInputLayoutname,textInputLayoutaddress,textInputLayoutphone,
            textInputLayoutpassword,textInputLayoutconfirmpassword;
    TextInputEditText textInputEditTextname,textInputEditTextaddress,textInputEditTextphone,textInputEditTextdate,
            textInputEditTextpassword,textInputEditTextconfirmpassword;
    AppCompatButton regesiter;
    apiinterface_home apiinterface;
    private List<contact_home> contactList;
    Spinner spinner;
    AppCompatTextView openlogin;

    Call<ResponseBody> call = null;
    String code,mVerificationId;
    ProgressDialog progressDialog;
    ProgressDialog progressDialog1;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_tager);

        inisialize();


        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regesiter.setClickable(false);
                if (textInputEditTextaddress.getText().toString().equals("") || textInputEditTextaddress.getText().toString() == null) {

                    textInputLayoutaddress.setError("أدخل العنوان");

                } else if (textInputEditTextname.getText().toString().equals("") || textInputEditTextname.getText().toString() == null) {

                    textInputLayoutname.setError("أدخل اسم المستخدم");

                } else if (textInputEditTextphone.getText().toString().equals("") || textInputEditTextphone.getText().toString() == null) {

                    textInputLayoutphone.setError("أدخل رقم الموبيل");

                } else if (textInputEditTextpassword.getText().toString().equals("") || textInputEditTextpassword.getText().toString() == null) {

                    textInputLayoutpassword.setError("أدخل كلمة المرور");

                } else if (textInputEditTextconfirmpassword.getText().toString().equals("") || textInputEditTextconfirmpassword.getText().toString() == null) {

                    textInputLayoutconfirmpassword.setError("أدخل  تأكيد كلمة المرور");

                } else if (!textInputEditTextconfirmpassword.getText().toString().equals(textInputEditTextpassword.getText().toString())) {
                    textInputLayoutconfirmpassword.setError("كلمة تأكيد مختلفة");

                    textInputEditTextconfirmpassword.setText("");
                } else {


                    fetchInfo();
                }
            }
        });


    }



    public void fetchInfo() {
        progressDialog = ProgressDialog.show(Register_tager.this, "جاري انشاء الحساب", "Please wait...", false, false);
        progressDialog.show();
        String phone=textInputEditTextphone.getText().toString();

        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_newaccount(textInputEditTextname.getText().toString(),
                textInputEditTextpassword.getText().toString(), textInputEditTextaddress.getText().toString()
                ,phone , 2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Register_tager.this);
                dlgAlert.setMessage("تم أنشاء حساب جديد بنجاح قم بأنشاء قسم له الان ");
                dlgAlert.setTitle("Torba App");
                dlgAlert.setPositiveButton("حسنا", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                 fetchInfo2();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Register_tager.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void inisialize() {
        textInputLayoutname = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutaddress = (TextInputLayout) findViewById(R.id.textInputLayoutaddress);
        textInputLayoutphone = (TextInputLayout) findViewById(R.id.textInputLayoutphone);
        textInputLayoutpassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textInputLayoutconfirmpassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);
        textInputEditTextname = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextphone = (TextInputEditText) findViewById(R.id.textInputEditTextphone);
        textInputEditTextaddress = (TextInputEditText) findViewById(R.id.textInputEditTextaddress);
        textInputEditTextpassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);


        textInputEditTextconfirmpassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);
        regesiter = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);
        openlogin = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

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
                Intent intent=new Intent(Register_tager.this,Add_second_category.class);
                intent.putStringArrayListExtra("category_list", arrayList);
                intent.putIntegerArrayListExtra("category_id",arrayList_id);
                intent.putExtra("password", textInputEditTextpassword.getText().toString());
                intent.putExtra("phone",textInputEditTextphone.getText().toString());
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<List<contact_home>> call, Throwable t) {

            }
        });
    }
}
