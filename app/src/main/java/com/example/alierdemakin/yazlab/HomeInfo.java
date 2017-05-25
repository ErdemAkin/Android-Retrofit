package com.example.alierdemakin.yazlab;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_info);
        FloatingActionButton fabEdit = (FloatingActionButton) findViewById(R.id.fabEdit);

        Bundle extras = getIntent().getExtras();
        final Gson gson = new Gson();
        final Home home = gson.fromJson(extras.getString("home"),Home.class);

        ListView imageList = (ListView) findViewById(R.id.imageList);

        List<Picture> picture = home.getPictures();
        String[] list ;
        if(picture.size() > 0)
        {
            list = new String[picture.size()];
            for(int i = 0 ; i < picture.size() ; i++){
                list[i] = picture.get(i).getResimYol();
            }
        }
        else
        {
            list = new String[1];
            list[0] = "http://i.gyazo.com/059b6cd618ca6e81a1167f89cb825f40.png";
        }

        ImageListAdapter imageAdapter = new ImageListAdapter(this,R.layout.slide,list);

        imageList.setAdapter(imageAdapter);

        information(home);

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeInfo.this,EditHome.class);
                intent.putExtra("home",gson.toJson(home));
                finish();
                startActivity(intent);
            }
        });
    }


    private void information(Home home){
        TextView evId = (TextView) findViewById(R.id.evID);
        TextView evIL = (TextView) findViewById(R.id.evIL);
        TextView evEmlakTip = (TextView) findViewById(R.id.evEmlakTip);
        TextView evAlan = (TextView) findViewById(R.id.evAlan);
        TextView evOdaSayisi = (TextView) findViewById(R.id.evOdaSayisi);
        TextView evBinaYasi = (TextView) findViewById(R.id.evBinaYasi);
        TextView evBulKat = (TextView) findViewById(R.id.evBulKat);
        TextView evFiyat = (TextView) findViewById(R.id.evFiyat);
        TextView evAciklama = (TextView) findViewById(R.id.evAciklama);

        evId.setText(home.getEvID());
        evIL.setText(home.getEvIL());
        evEmlakTip.setText(home.getEvEmlakTip());
        evAlan.setText(home.getEvAlan());
        evOdaSayisi.setText(home.getEvOdaSayisi());
        evBinaYasi.setText(home.getEvBinaYasi());
        evBulKat.setText(home.getEvBulKat());
        evFiyat.setText(home.getEvFiyat());
        evAciklama.setText(home.getEvAciklama());
    }
}
