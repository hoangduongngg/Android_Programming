package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.model.TechnologyAdapter;
import com.example.listview.model.TechnologyObject;

public class ListViewObjectActivity extends AppCompatActivity {
    private ListView listView;
    TechnologyAdapter adapter;
    private TechnologyObject[] list;

    //Create a menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFile:
                Toast.makeText(this, "File", Toast.LENGTH_LONG).show();
                break;
            case R.id.mEmail:
                Toast.makeText(this, "Email", Toast.LENGTH_LONG).show();
                break;
            case R.id.mPhone:
                Toast.makeText(this, "Phone", Toast.LENGTH_LONG).show();
                break;
            case R.id.mExit:
                System.exit(0);
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    // Begin Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_object);
        init();
        initData();
        adapter = new TechnologyAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for (int i = 0; i<listView.getAdapter().getCount(); i++) {
                    listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                listView.getChildAt(position).setBackgroundColor(Color.GREEN);

                TechnologyObject t = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), t.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void init() {
        listView = findViewById(R.id.listView);
    }
    private void initData() {
        Integer[] imgs = {  R.drawable.cloudstorage,
                            R.drawable.embeddedsystem,
                            R.drawable.machinelearning,
                            R.drawable.restfulapi
                        };
        String[] names = {  "Cloud Storage",
                            "Embedded System",
                            "Machine Learing",
                            "Restful API"
                        };
        String[] subs = {
                "Active",
                "Active",
                "Active",
                "Active"
        };
        String[] describes = {
                "A describe for technology object.",
                "A describe for technology object.",
                "A describe for technology object.",
                "A describe for technology object."
        };

        list = new TechnologyObject[imgs.length];
        for (int i=0; i<list.length; i++) {
            list[i] = new TechnologyObject(imgs[i], names[i], subs[i],describes[i] );
        }

    }
}