package com.example.alierdemakin.yazlab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by AliErdem.Akin on 19.05.2017.
 */

public class ImageListAdapter extends ArrayAdapter<String> {
    Context context;
    int layoutResId;
    String data[] = null;

    public ImageListAdapter(Context context, int layoutResId, String[] data) {
        super(context, layoutResId, data);
        this.layoutResId = layoutResId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HistoryHolder holder = null;

        if(convertView == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResId, parent, false);

            holder = new HistoryHolder();
            holder.imageIcon = (ImageView)convertView.findViewById(R.id.icon);

            convertView.setTag(holder);
        }
        else
        {
            holder = (HistoryHolder)convertView.getTag();
        }

        String history = data[position];

        Picasso.with(this.context).load(history).into(holder.imageIcon);


        return convertView;
    }

    static class HistoryHolder
    {
        ImageView imageIcon;
    }
}
