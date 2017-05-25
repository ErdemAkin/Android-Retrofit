package com.example.alierdemakin.yazlab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by AliErdem.Akin on 18.05.2017.
 */

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Home> listHome ;

    public CustomAdapter(Activity activity, List<Home> home){
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        listHome = home;
    }

    @Override
    public int getCount() {
        return listHome.size();
    }

    @Override
    public Home getItem(int position) {
        return listHome.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = mInflater.inflate(R.layout.list_row,null);

        TextView textID = (TextView) rowView.findViewById(R.id.txtID);
        TextView textIL = (TextView) rowView.findViewById(R.id.txtIL);
        TextView textFiyat = (TextView) rowView.findViewById(R.id.txtFiyat);

        Home home = listHome.get(position);

        textID.setText(home.getEvID());
        textIL.setText(home.getEvIL());
        textFiyat.setText(home.getEvFiyat());

        return rowView;
    }

}
