package com.example.intentlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    Button bt1, bt2;
    TextInputEditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
//Quay laij Login
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent();
                String u = user.getText().toString();
                String p = pass.getText().toString();

                t.putExtra("u", u);
                t.putExtra("p", p);

                setResult(RESULT_OK, t);

                finish();

            }
        });
//        Cancel
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent();
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }
}