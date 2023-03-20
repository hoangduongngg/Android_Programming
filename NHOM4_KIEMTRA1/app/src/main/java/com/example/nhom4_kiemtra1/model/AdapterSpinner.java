package com.example.nhom4_kiemtra1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.nhom4_kiemtra1.R;

public class AdapterSpinner extends BaseAdapter {
    private int[] image;
    private String context;

    public AdapterSpinner(int[] image) {
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_spinner, viewGroup, false);
        ImageView img = v.findViewById(R.id.img);
        img.setImageResource();

        return null;
    }
}
