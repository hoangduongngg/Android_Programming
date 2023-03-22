package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter <String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = adapter.getItem(i);
                Toast.makeText(getApplicationContext(), selection, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init() {
        listView = findViewById(R.id.listView);
    }

    private void initListView() {
        String[] list = getResources().getStringArray(R.array.Technology);
        adapter = new ArrayAdapter<>(this, R.layout.item, list);
        listView.setAdapter(adapter);
    }


}