package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.intentdemo.model.Student;

public class MainActivity2 extends AppCompatActivity {
    Button bt;
    TextView txt;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt = findViewById(R.id.btBack);
        txt = findViewById(R.id.txt);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer age = intent.getIntExtra("age", 22);
        String[] subs = intent.getStringArrayExtra("subs");

        String str = "Hello" + name + age.toString();
        for (String i:subs) {
            str += i + ";";
        }

        Student student = (Student) intent.getSerializableExtra("student");

        str += student.getName();

//        img.setImageResource(student.getImg());
        txt.setText(str);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}