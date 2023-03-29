package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button btA, btB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btA=findViewById(R.id.bta);
        btB=findViewById(R.id.btb);
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment fg;
        switch(view.getId()){
            case R.id.bta:
                fg=new FragmentA();
                transaction.add(R.id.fragment,fg);
                break;
            case R.id.btb:
                fg=new FragmentB();
                transaction.add(R.id.fragment,fg);
                break;
        }
        transaction.commit();
    }
}