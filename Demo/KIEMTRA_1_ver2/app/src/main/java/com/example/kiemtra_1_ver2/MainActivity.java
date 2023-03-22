package com.example.kiemtra_1_ver2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.kiemtra_1_ver2.model.AdapterSpinner;
import com.example.kiemtra_1_ver2.model.Cat;
import com.example.kiemtra_1_ver2.model.CatAdapter;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener{
    private Spinner sp;
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private EditText eName, eDescribe, ePrice;
    private Button btAdd, btUpdate;
    private int pcurr;  //Vi tri hien tai ma minh chon


    private int[] images = {R.drawable.cat1,R.drawable.cat2,
            R.drawable.cat3, R.drawable.cat4,
            R.drawable.cat5,R.drawable.cat6 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new CatAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.add(new Cat(R.drawable.cat1, "Bento", "Lovely", 100));

        adapter.setClickListener(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String itemSp = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String des = eDescribe.getText().toString();
                String p = ePrice.getText().toString();

                int img = R.drawable.cat1;
                double price = 0;

                try {
                    img = images[Integer.parseInt(itemSp)];
                    price = Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDes(des);
                    cat.setPrice(price);
                    adapter.add(cat);
                    Toast.makeText(getApplicationContext(), "Add data successfully!", Toast.LENGTH_LONG).show();

                }catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid data!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String itemSp = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String des = eDescribe.getText().toString();
                String p = ePrice.getText().toString();

                int img = R.drawable.cat1;
                double price = 0;

                try {
                    img = images[Integer.parseInt(itemSp)];
                    price = Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDes(des);
                    cat.setPrice(price);
                    adapter.update(pcurr, cat);
                    Toast.makeText(getApplicationContext(), "Update data successfully!", Toast.LENGTH_LONG).show();
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid data!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void initView() {
        sp = findViewById(R.id.img);
        AdapterSpinner adapterSpinner = new AdapterSpinner(this);
        sp.setAdapter(adapterSpinner);

        recyclerView = findViewById(R.id.recycleView);
        eName = findViewById(R.id.name);
        eDescribe = findViewById(R.id.describe);
        ePrice = findViewById(R.id.price);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);

        btUpdate.setEnabled(false);
    }

    // Khi click btUpdate => Lay vi tri do, mo nut Add va Hien nut Update len
    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        pcurr = position;
        Cat cat = adapter.getItem(position);
        int img = cat.getImg();
        int p = 0;
        for (int i=0; i<images.length; i++) {
            if (img == images[i]) {
                p=i;
                break;
            }
        }
        sp.setSelection(p);
        eName.setText(cat.getName());
        eDescribe.setText(cat.getDes());
        ePrice.setText(cat.getPrice() + "");
    }
}