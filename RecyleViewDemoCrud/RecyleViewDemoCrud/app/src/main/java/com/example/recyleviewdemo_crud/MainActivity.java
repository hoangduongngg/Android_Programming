package com.example.recyleviewdemo_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.recyleviewdemo_crud.model.Cat;
import com.example.recyleviewdemo_crud.model.CatAdapter;
import com.example.recyleviewdemo_crud.model.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener,
        SearchView.OnQueryTextListener{
    private Spinner sp;
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private EditText eName, eDes,ePrice;
    private Button btAdd, btUpdate;
    private SearchView searchView;
    private int pcurr;
    private  int[] imgs={R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5, R.drawable.img_2,R.drawable.img_3};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new CatAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListner(this);
        searchView.setOnQueryTextListener(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String desc = eDes.getText().toString();
                String p = ePrice. getText().toString();
                int img = R.drawable.img_2;
                double price = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDescribe(desc);
                    cat.setPrice(price);
                    adapter.add(cat);
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhaplai",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String desc = eDes.getText().toString();
                String p = ePrice. getText().toString();
                int img = R.drawable.img_2;
                double price = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDescribe(desc);
                    cat.setPrice(price);
                    adapter.update(pcurr,cat);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhaplai",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        sp = findViewById(R.id.img);
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        sp.setAdapter(adapter);
        recyclerView = findViewById(R.id.recycleView);
        eName = findViewById(R.id.name);
        eDes = findViewById(R.id.describe);
        ePrice = findViewById(R.id.price);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView = findViewById(R.id.search);
    }

    @Override
    public void onItemClick(View view, int positon) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        pcurr = positon;
        Cat cat = adapter.getItem(positon);
        int img = cat.getImg();
        int p=0;
        for (int i=0; i < imgs.length ; i++){
            if (imgs[i] == img){
                p = i;
                break;
            }

        }
        sp.setSelection(p);
        eName.setText(cat.getName());
        eDes.setText(cat.getDescribe());
        ePrice.setText(cat.getPrice()+"");
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }

    private void filter(String s) {
        List<Cat> filterlist = new ArrayList<>();
        for(Cat i:adapter.getBackup()){
            if (i.getName().toLowerCase().contains(s.toLowerCase())){
                filterlist.add(i);
            }
        }
        if (filterlist.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else {
            adapter.filterList(filterlist);
        }
    }
}