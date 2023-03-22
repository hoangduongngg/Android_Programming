package com.example.kiemtra_1_ver2.model;

public class Cat {
    private int img;
    private String name, des;
    private double price;

    public Cat() {
    }

    public Cat(int img, String name, String des, double price) {
        this.img = img;
        this.name = name;
        this.des = des;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                '}';
    }
}
