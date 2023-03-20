package com.example.nhom4_kiemtra1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.nhom4_kiemtra1.model.AdapterSpinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    AdapterSpinner adapterSpinner;

    int[] img = {R.drawable.haku, R.drawable.her};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        adapterSpinner = new AdapterSpinner(img);
        sp.setAdapter(adapterSpinner);

    }
}