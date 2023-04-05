package com.example.intentlogindemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private final static int REQUEST_CODE = 10000;
    Button bt1, bt2;
    TextInputEditText user, pass;
    String u;
    String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivityForResult(t, REQUEST_CODE);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u1 = user.getText().toString();
                String p1 = pass.getText().toString();
                Intent t = new Intent(LoginActivity.this, RegisterActivity.class);
                t.putExtra("u", u);
                t.putExtra("p", p);

                t.putExtra("u1", u1);
                t.putExtra("p1", p1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode== RESULT_OK) {
            if (data != null) {
                u = data.getStringExtra("u");
                p = data.getStringExtra("p");
            }
//            else {
//                Toast.makeText(this, "Khong dang ky", Toast.LENGTH_LONG).show();
//            }
        }
        else {
            Toast.makeText(this, "Khong dang ky", Toast.LENGTH_LONG).show();
        }
    }


}