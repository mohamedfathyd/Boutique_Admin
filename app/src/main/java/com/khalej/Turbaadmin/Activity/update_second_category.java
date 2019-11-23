package com.khalej.Turbaadmin.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.khalej.HelpMe.R;
import com.khalej.Turbaadmin.Adapter.RecyclerAdapter_allfirstupdate;
import com.khalej.Turbaadmin.Adapter.RecyclerAdapter_allsecondupdate;
import com.khalej.Turbaadmin.model.Apiclient_home;
import com.khalej.Turbaadmin.model.apiinterface_home;
import com.khalej.Turbaadmin.model.contact_home;
import com.khalej.Turbaadmin.model.contact_second_home;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class update_second_category extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter_allsecondupdate recyclerAdapter_secondry;
    private List<contact_second_home> contactList;
    private apiinterface_home apiinterface;
    int id = 0;
    String name;
    int sec_id;
    Typeface myTypeface;
    Intent intent;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_second_category);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        textView = (TextView) findViewById(R.id.toolbar_title);
        progressBar.setVisibility(View.VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        intent = getIntent();

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

        recyclerView = (RecyclerView) findViewById(R.id.review);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInfo();
    }

    public void fetchInfo() {
        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_second_home>> call = apiinterface.get_all_category();
        call.enqueue(new Callback<List<contact_second_home>>() {
            @Override
            public void onResponse(Call<List<contact_second_home>> call, Response<List<contact_second_home>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerAdapter_secondry = new RecyclerAdapter_allsecondupdate(update_second_category.this, contactList);
                recyclerView.setAdapter(recyclerAdapter_secondry);


            }

            @Override
            public void onFailure(Call<List<contact_second_home>> call, Throwable t) {

            }
        });
    }

}
