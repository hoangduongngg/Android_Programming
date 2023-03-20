package com.example.testonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eNum1, eNum2;
    Button btnSum;

    TextView txtRes;
    Spinner spTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TraKetQua(view, "Tong");
            }
        });

        spTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sp = spTinh.getSelectedItem().toString();
                TraKetQua(view, sp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initView () {
        eNum1 = findViewById(R.id.eNum2);
        eNum2 = findViewById(R.id.eNum1);
        btnSum = findViewById(R.id.btnSum);
        txtRes = findViewById(R.id.txtRes);
        spTinh = findViewById(R.id.spTinh);

//        String[] st = getResources().getStringArray(R.array.tinh);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                R.layout.item, st);
//        spTinh.setAdapter(adapter);
    }

    public void TraKetQua (View view, String PhepTinh) {
        String sn1 = eNum1.getText().toString();
        String sn2 = eNum2.getText().toString();
        double n1, n2;
        try {
            n1 = Double.parseDouble(sn1);
            n2 = Double.parseDouble(sn2);
            String res = TinhToan(n1, n2, PhepTinh);
            txtRes.setText(res);
            Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "De nghi nhap so!", Toast.LENGTH_LONG).show();
        }

    }

    public String TinhToan (Double x, Double y, String PhepTinh) {
        String res = "";
        switch (PhepTinh) {
            case "Tong": res += "Tong: " + (x+y); break;
            case "Hieu": res += "Hieu: " + (x-y); break;
            case "Tich": res+= "Tich: " + (x*y); break;
            case "Thuong":
                if (x==0 || y==0) {
                    res += "Khong chia duoc cho 0";
                }
                else {
                    res+= "Thuong: " + (x/y); break;
                }
        }
        return  res;

    }
}