package com.example.listview.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.R;

public class TechnologyAdapter extends ArrayAdapter<TechnologyObject> {

    private Context context;
    private TechnologyObject[] listTech;
    public TechnologyAdapter(@NonNull Context context, TechnologyObject[] listTech) {
        super(context, R.layout.item_object, listTech);
        this.context = context;
        this.listTech = listTech;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_object, null, true);
        ImageView tech_img = view.findViewById(R.id.tech_img);
        TextView tech_name = view.findViewById(R.id.tech_name);
        TextView tech_sub = view.findViewById(R.id.tech_sub);
        TextView tech_describe = view.findViewById(R.id.tech_describe);

        TechnologyObject tech = listTech[position];
        tech_img.setImageResource(tech.getImg());
        tech_name.setText(tech.getName());
        tech_sub.setText(tech.getSub());
        tech_describe.setText(tech.getDescribe());

        return view;
    }

    public TechnologyObject getItem (int position) {
        return listTech[position];
    }

}
