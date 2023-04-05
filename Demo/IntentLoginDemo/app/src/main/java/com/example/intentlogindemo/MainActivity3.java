package com.example.intentlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txt = findViewById(R.id.txt);
        Intent t = getIntent();

        String u = t.getStringExtra("u");
        String p = t.getStringExtra("p");
        String u1 = t.getStringExtra("u1");
        String p1 = t.getStringExtra("p1");

        if (u.equalsIgnoreCase(u1) && p.equalsIgnoreCase(p1)) {
            txt.setText("Hello" + u);
        }
        else {
            txt.setText("Hello" + u);
        }

    }
}