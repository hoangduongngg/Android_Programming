package com.example.kiemtra_1_ver2.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.kiemtra_1_ver2.R;

public class AdapterSpinner extends BaseAdapter {
    private int[] images = {R.drawable.cat1,R.drawable.cat2,
            R.drawable.cat3, R.drawable.cat4,
            R.drawable.cat5,R.drawable.cat6 };
    private Context context;

    public AdapterSpinner( Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_image, viewGroup, false);
        ImageView img = item.findViewById(R.id.img);
        img.setImageResource(images[position]);

        return item;
    }
}
