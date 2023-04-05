package com.example.intentdemo.model;

import java.io.Serializable;

public class Student implements Serializable {
    private int img;
    private String name;

    public Student(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public Student() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
