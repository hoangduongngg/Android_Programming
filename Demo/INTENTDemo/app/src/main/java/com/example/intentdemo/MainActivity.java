package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.intentdemo.model.Student;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.btOpen);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", "Nguyen Van A");
                intent.putExtra("age", 20);

                String[] subs = {"aaa", "bbb"};
                intent.putExtra("subs", subs);

                Student student = new Student(R.drawable.cat1, "Nguyen Van A");
                intent.putExtra("student", student);

                startActivity(intent);
            }
        });
    }
}