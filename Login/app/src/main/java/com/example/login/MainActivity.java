package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin, btnAbout, btnContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btnLogin.setOnClickListener(this);

        btnAbout.setOnClickListener(this);

        btnContact.setOnClickListener(this);

    }

    private void initView () {
        btnLogin = findViewById(R.id.btlLogin);
        btnAbout = findViewById(R.id.btnAbout);
        btnContact = findViewById(R.id.btnContact);
    }

    public void openActivity (Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view==btnLogin) {
            openActivity(LoginActivity.class);
        }
        if (view==btnAbout) {
            openActivity(LoginActivity.class);
        }
        if (view==btnAbout) {
            openActivity(LoginActivity.class);
        }
    }
}