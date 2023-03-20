package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin, btnLinkSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(view);
            }
        });

//        btnLinkSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openSignUpActivity();
//            }
//        });

    }

    private void initView () {
        username= findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btlLogin);
        btnLinkSignUp = findViewById(R.id.btnLinkSignUp);
    }

    public void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
    public void Login (View view) {
        String str_user = username.getText().toString();
        String str_pass = password.getText().toString();

        String user_correct = "admin";
        String pass_correct = "admin";

        if (TextUtils.isEmpty(str_user) || TextUtils.isEmpty(str_pass)) {
            Toast.makeText(this, "Empty Input!", Toast.LENGTH_LONG).show();
        }
        else if (str_user.equals(user_correct) && str_pass.equals((pass_correct))) {
            Toast.makeText(this, "Login!", Toast.LENGTH_LONG).show();
        }
        else  {
            Toast.makeText(this, "Wrong username or password!", Toast.LENGTH_LONG).show();

        }
    }
}