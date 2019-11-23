package com.khalej.Turbaadmin.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.khalej.HelpMe.R;
import com.khalej.Turbaadmin.Adapter.RecyclerAdapter_recervations_withMandop;
import com.khalej.Turbaadmin.Adapter.RecyclerAdapter_recervations_withMandop_;
import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.VISIBLE;

public class Orders_Month extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter_recervations_withMandop_ recyclerAdapter_secondry;
    private List<contact_order> contactList;
    private apiinterface_home apiinterface;
    int id = 0;
    String name;
    int user_id;
    Spinner spinner;
    ImageView aa;
    String date;
    int sec_id;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    Typeface myTypeface;
    Intent intent;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders__month);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        textView = (TextView) findViewById(R.id.toolbar_title);
        progressBar.setVisibility(VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        if (Build.VERSION.SDK_INT >= 23) {
            //do your check here
            isStoragePermissionGranted();
        }
        intent = getIntent();

        spinner=findViewById(R.id.spin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner.getSelectedItem().toString().equals("يناير")) {
                    date="01";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("فبراير")) {
                    date="02";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("مارس")) {
                    date="03";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("ابريل")) {
                    date="04";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("مايو")) {
                    date="05";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("يونيو")) {
                    date="06";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("يوليو")) {
                    date="07";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("اغسطس")) {
                    date="08";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("سبتمبر")) {
                    date="09";
                    fetchInfo();
                }  if (spinner.getSelectedItem().toString().equals("اكتوبر")) {
                    date="10";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("نوفمبر")) {
                    date="11";
                    fetchInfo();
                }
                if (spinner.getSelectedItem().toString().equals("ديسمبر")) {
                    date="12";
                    fetchInfo();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
        aa=findViewById(R.id.aa);
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocsv();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.review);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(VISIBLE);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInfo();
    }

    public void fetchInfo() {
        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_order>> call = apiinterface.get_all_neworders_month(date);
        call.enqueue(new Callback<List<contact_order>>() {
            @Override
            public void onResponse(Call<List<contact_order>> call, Response<List<contact_order>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerAdapter_secondry = new RecyclerAdapter_recervations_withMandop_(Orders_Month.this, contactList);
                recyclerView.setAdapter(recyclerAdapter_secondry);


            }

            @Override
            public void onFailure(Call<List<contact_order>> call, Throwable t) {

            }
        });
    }

    public void  addtocsv(){

        final ArrayList<String[]> data = new ArrayList<>();
        final String[] a=new String[100];
        final String[] b=new String[100];
        final String[] c=new String[100];
        final String[] d=new String[100];
        final String[] e=new String[100];
        final String[] f=new String[100];
        final String[] g=new String[100];
        for(int i= 0;i<contactList.size();i++){
            a[i]=contactList.get(i).getName();
            b[i]=contactList.get(i).getPhone();
            c[i]=contactList.get(i).getAddress();
            d[i]=contactList.get(i).getPrice()+"ريال";
            e[i]=contactList.get(i).getMandop();
            f[i]=contactList.get(i).getDate();
            g[i]=contactList.get(i).getDetails();

        }
        data.add(a);
        data.add(b);
        data.add(c);
        data.add(d);
        data.add(e);
        data.add(f);
        data.add(g);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("اسم الملف ليتم حفظه : ");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    File root = new File(Environment.getExternalStorageDirectory(), "Turba");
                    if (!root.exists()) {
                        root.mkdirs();
                    }
                    File gpxfile = new File(root, input.getText().toString()+".txt");
                    FileWriter writer = new FileWriter(gpxfile);
                    for(int i= 0;i<contactList.size();i++){
                        writer.append("الاسم :" +contactList.get(i).getName()+"\n");
                        writer.append("التاريخ :" +contactList.get(i).getDate()+"\n");
                        writer.append("رقم الهاتف :"+ contactList.get(i).getPhone()+"\n");
                        writer.append("العنوان  :"+ contactList.get(i).getAddress()+"\n");
                        writer.append("السعر  :"+ contactList.get(i).getPrice()+"ريال"+ "\n\n" );
                        writer.append("تفاصيل  :"+ contactList.get(i).getDetails()+ "\n\n" );
                        writer.append("المندوب  :"+ contactList.get(i).getMandop()+ "\n\n" );
                        writer.append("___________________________________________________________"+"\n");



                    }
                    writer.flush();
                    writer.close();
                    Toast.makeText(Orders_Month.this,"تم الحفظ فى ملفات الهاتف " , Toast.LENGTH_LONG).show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                 return true;
            } else {

                 ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation

            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

        }
    }
}
