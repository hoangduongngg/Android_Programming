package com.example.touch_exampledemo;
//7.2. Lập trình thiết bị di động bằng Java- Lớp ScaleGestureDetector => Nhieu thao tac bang 1 ngon
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener,
        View.OnTouchListener {
    private TextView e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12;
    private ImageView img;

    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        //Bat su kien cham
        img.setOnTouchListener(this);
        detector = new GestureDetector(this, this);

        //Bat su kiem Double Tap
        detector.setOnDoubleTapListener(this);
    }

    private void initView() {
        img = findViewById(R.id.img);
        e1 = findViewById(R.id.txt1);
        e2 = findViewById(R.id.txt2);
        e3 = findViewById(R.id.txt3);
        e4 = findViewById(R.id.txt4);
        e5 = findViewById(R.id.txt5);
        e6 = findViewById(R.id.txt6);
        e7 = findViewById(R.id.txt7);
        e8 = findViewById(R.id.txt8);
        e9 = findViewById(R.id.txt9);
        e10 = findViewById(R.id.txt10);
        e11 = findViewById(R.id.txt11);
        e12 = findViewById(R.id.txt12);
    }

    //Keo Xuong
    @Override
    public boolean onDown(@NonNull MotionEvent event) {
        e1.setText("Down Touch");
        e2.setText("x:" + event.getX() + " y:" + event.getY());
        return true;
    }

    //An nut
    @Override
    public void onShowPress(@NonNull MotionEvent event) {
        e3.setText("Show Press");
        e4.setText("x:" + event.getX() + " y:" + event.getY());
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent event) {
        e5.setText("Single Tap Up");
        e6.setText("x:" + event.getX() + " y:" + event.getY());
        return false;
    }

    //Truot
    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent event, float v, float v1) {
        e7.setText("Scroll");
        e8.setText("x:" + event.getX() + " y:" + event.getY());
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(@NonNull MotionEvent event, @NonNull MotionEvent motionEvent1, float v, float v1) {
        e9.setText("Fling");
        e10.setText("x:" + event.getX() + " y:" + event.getY());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent event) {
        e11.setText("Double Tap Event");
        e12.setText("x:" + event.getX() + " y:" + event.getY());
        return true;
    }

    // Su kien cham
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }
}