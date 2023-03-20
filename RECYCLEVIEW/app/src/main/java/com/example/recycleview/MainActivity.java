package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleview.Model.Cat;
import com.example.recycleview.Model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RView);
        adapter = new CatAdapter(getList());
        GridLayoutManager manager = new GridLayoutManager(this, 3);     //So cot
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    private List<Cat> getList() {
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.haku, "Name1"));
        list.add(new Cat(R.drawable.haku, "Name2"));
        list.add(new Cat(R.drawable.haku, "Name3"));
        list.add(new Cat(R.drawable.haku, "Name4"));
        list.add(new Cat(R.drawable.haku, "Name4"));
        list.add(new Cat(R.drawable.haku, "Name4"));
        return list;
    }
}