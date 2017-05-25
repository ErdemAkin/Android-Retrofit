package com.example.alierdemakin.yazlab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    final Activity activity = this;

    List<Home> listHome = new ArrayList<Home>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/WSdemo/homeinfo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestController service = retrofit.create(RestController.class);
        Call<List<Home>> allHome = service.getAllHome();

        allHome.enqueue(new Callback<List<Home>>() {
            @Override
            public void onResponse(Call<List<Home>> call, Response<List<Home>> response) {
                List<Home> homes = response.body();
                final ListView myList = (ListView) findViewById(R.id.liste);
                final CustomAdapter myAdaptor = new CustomAdapter(activity,homes);
                myList.setAdapter(myAdaptor);

                myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Home home = myAdaptor.getItem(position);
                        Intent activity = new Intent(MainActivity.this,HomeInfo.class);
                        activity.putExtra("home",new Gson().toJson(home));
                        finish();
                        startActivity(activity);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Home>> call, Throwable t) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddHome.class);
                startActivity(intent);
            }
        });
    }
}
