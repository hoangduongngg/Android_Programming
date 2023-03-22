package com.example.testonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText eTime, eDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        init();

        eTime.setOnClickListener(this);
        eDate.setOnClickListener(this);
    }

    private void init() {
        eTime = findViewById(R.id.eTime);
        eDate = findViewById(R.id.eDate);
    }

    @Override
    public void onClick(View view) {
        if (view==eTime) {
            Calendar c = Calendar.getInstance();
            int hour_current = c.get(Calendar.HOUR_OF_DAY);
            int min_current = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    eTime.setText(h + ":"+ m);
                }
            }, hour_current, min_current,false);

            timePickerDialog.show();
        }

        else if (view == eDate) {
            Calendar c = Calendar.getInstance();
            int y_current = c.get(Calendar.YEAR);
            int m_current = c.get(Calendar.MONDAY);
            int d_curent = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    eDate.setText(y+"/"+(m+1)+"/"+d);
                }
            }, y_current, m_current, d_curent);

            datePickerDialog.show();
        }
    }
}