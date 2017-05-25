package com.example.alierdemakin.yazlab;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AddHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home);

        final TextView evIL = (TextView) findViewById(R.id.newEvIL);
        final TextView evEmlakTip = (TextView) findViewById(R.id.newEvEmlakTip);
        final TextView evAlan = (TextView) findViewById(R.id.newEvAlan);
        final TextView evOdaSayisi = (TextView) findViewById(R.id.newEvOdaSayisi);
        final TextView evBinaYasi = (TextView) findViewById(R.id.newEvBinaYasi);
        final TextView evBulKat = (TextView) findViewById(R.id.newEvBulKat);
        final TextView evFiyat = (TextView) findViewById(R.id.newEvFiyat);
        final TextView evAciklama = (TextView) findViewById(R.id.newEvAciklama);
        final TextView evPic1 = (TextView) findViewById(R.id.newPic1);
        final TextView evPic2 = (TextView) findViewById(R.id.newPic2);
        final TextView evPic3 = (TextView) findViewById(R.id.newPic3);
        Button btn = (Button) findViewById(R.id.btn_login);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home home = new Home();
                home.setEvIL(evIL.getText().toString());
                home.setEvEmlakTip(evEmlakTip.getText().toString());
                home.setEvAlan(evAlan.getText().toString());
                home.setEvOdaSayisi(evOdaSayisi.getText().toString());
                home.setEvBinaYasi(evBinaYasi.getText().toString());
                home.setEvBulKat(evBulKat.getText().toString());
                home.setEvFiyat(evFiyat.getText().toString());
                home.setEvAciklama(evAciklama.getText().toString());

                Picture pic1 = new Picture();
                if(evPic1.getText().toString().matches("")){
                    pic1.setResimYol("http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png");
                }else{
                    pic1.setResimYol(evPic1.getText().toString());
                }

                Picture pic2 = new Picture();
                if(evPic2.getText().toString().matches("")){
                    pic2.setResimYol("http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png");
                }else{
                    pic2.setResimYol(evPic2.getText().toString());
                }

                Picture pic3 = new Picture();
                if(evPic3.getText().toString().matches("")){
                    pic3.setResimYol("http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png");
                }else{
                    pic3.setResimYol(evPic3.getText().toString());
                }

                List<Picture> pictures = new ArrayList<Picture>();
                pictures.add(pic1);
                pictures.add(pic2);
                pictures.add(pic3);
                home.setPictures(pictures);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/WSdemo/homeinfo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RestController service = retrofit.create(RestController.class);
                Gson gson = new Gson();
                String param = gson.toJson(home);
                Call<String> insertHome = service.insertHome(param);

                insertHome.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

                Intent intent = new Intent(AddHome.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                AddHome.this.startActivity(intent);
            }
        });

    }
}
