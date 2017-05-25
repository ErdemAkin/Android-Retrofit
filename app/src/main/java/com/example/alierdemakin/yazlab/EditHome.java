package com.example.alierdemakin.yazlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_home);

        Bundle extras = getIntent().getExtras();
        final Gson gson = new Gson();
        final Home home = gson.fromJson(extras.getString("home"),Home.class);

        final TextView evIL = (TextView) findViewById(R.id.editEvIL);
        final TextView evEmlakTip = (TextView) findViewById(R.id.editEvEmlakTip);
        final TextView evAlan = (TextView) findViewById(R.id.editEvAlan);
        final TextView evOdaSayisi = (TextView) findViewById(R.id.editEvOdaSayisi);
        final TextView evBinaYasi = (TextView) findViewById(R.id.editEvBinaYasi);
        final TextView evBulKat = (TextView) findViewById(R.id.editEvBulKat);
        final TextView evFiyat = (TextView) findViewById(R.id.editEvFiyat);
        final TextView evAciklama = (TextView) findViewById(R.id.editEvAciklama);
        final TextView evPic1 = (TextView) findViewById(R.id.editPic1);
        final TextView evPic2 = (TextView) findViewById(R.id.editPic2);
        final TextView evPic3 = (TextView) findViewById(R.id.editPic3);
        final Button btn_edit = (Button) findViewById(R.id.btn_edit);
        final Button btn_delete = (Button) findViewById(R.id.btn_delete);

        evIL.setText(home.getEvIL());
        evEmlakTip.setText(home.getEvEmlakTip());
        evAlan.setText(home.getEvAlan());
        evOdaSayisi.setText(home.getEvOdaSayisi());
        evBinaYasi.setText(home.getEvBinaYasi());
        evBulKat.setText(home.getEvBulKat());
        evFiyat.setText(home.getEvFiyat());
        evAciklama.setText(home.getEvAciklama());
        if(home.getPictures().size() > 0)
        {
            evPic1.setText(home.getPictures().get(0).getResimYol());
            evPic2.setText(home.getPictures().get(1).getResimYol());
            evPic3.setText(home.getPictures().get(2).getResimYol());
        }

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Home editHome = new Home();
                editHome.setEvID(home.getEvID());
                editHome.setEvIL(evIL.getText().toString());
                editHome.setEvEmlakTip(evEmlakTip.getText().toString());
                editHome.setEvAlan(evAlan.getText().toString());
                editHome.setEvOdaSayisi(evOdaSayisi.getText().toString());
                editHome.setEvBinaYasi(evBinaYasi.getText().toString());
                editHome.setEvBulKat(evBulKat.getText().toString());
                editHome.setEvFiyat(evFiyat.getText().toString());
                editHome.setEvAciklama(evAciklama.getText().toString());

                List<Picture> pictureList = new ArrayList<Picture>();
                Picture picture1 = new Picture();
                Picture picture2 = new Picture();
                Picture picture3 = new Picture();
                if(evPic1.getText().toString().matches(""))
                    picture1.setResimYol("http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png");
                else
                    picture1.setResimYol(evPic1.getText().toString());
                picture1.setResimEvID(home.getEvID());

                if(evPic2.getText().toString().matches(""))
                    picture2.setResimYol("http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png");
                else
                    picture2.setResimYol(evPic2.getText().toString());
                picture2.setResimEvID(home.getEvID());

                if(evPic3.getText().toString().matches(""))
                    picture3.setResimYol("http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png");
                else
                    picture3.setResimYol(evPic3.getText().toString());
                picture3.setResimEvID(home.getEvID());

                pictureList.add(picture1);
                pictureList.add(picture2);
                pictureList.add(picture3);
                editHome.setPictures(pictureList);

                final Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/WSdemo/homeinfo/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                RestController service = retrofit.create(RestController.class);
                String param = gson.toJson(editHome);
                Call<String> updateHome = service.updateHome(param);

                updateHome.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Intent intent = new Intent(EditHome.this,HomeInfo.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("home",gson.toJson(editHome));
                        finish();
                        EditHome.this.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        t.getMessage();
                    }
                });
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home editHome = new Home();
                editHome.setEvID(home.getEvID());
                editHome.setEvIL(evIL.getText().toString());
                editHome.setEvEmlakTip(evEmlakTip.getText().toString());
                editHome.setEvAlan(evAlan.getText().toString());
                editHome.setEvOdaSayisi(evOdaSayisi.getText().toString());
                editHome.setEvBinaYasi(evBinaYasi.getText().toString());
                editHome.setEvBulKat(evBulKat.getText().toString());
                editHome.setEvFiyat(evFiyat.getText().toString());
                editHome.setEvAciklama(evAciklama.getText().toString());

                List<Picture> pictureList = new ArrayList<Picture>();
                Picture picture1 = new Picture();
                Picture picture2 = new Picture();
                Picture picture3 = new Picture();
                picture1.setResimYol(evPic1.getText().toString());
                picture1.setResimEvID(home.getEvID());
                picture2.setResimYol(evPic2.getText().toString());
                picture2.setResimEvID(home.getEvID());
                picture3.setResimYol(evPic3.getText().toString());
                picture3.setResimEvID(home.getEvID());
                pictureList.add(picture1);
                pictureList.add(picture2);
                pictureList.add(picture3);
                editHome.setPictures(pictureList);

                final Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/WSdemo/homeinfo/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                RestController service = retrofit.create(RestController.class);
                String param = gson.toJson(editHome);

                Call<String> deleteHome = service.deleteHome(param);

                deleteHome.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Intent intent = new Intent(EditHome.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        finish();
                        EditHome.this.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

            }
        });
    }
}
