package com.example.bruhshua.restaurantapp;

import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by bruhshua on 2/3/17.
 */
//POJO for each item in the menu
public class MenuItem {

    private int picture;
    private String name;
    private double price;
    private String size;
    private int quantity;

    public void setPrice(double price) {
        this.price = price;
    }
    public MenuItem(){}

    public MenuItem(int pic, String name, double price){
        this.picture = pic;
        this.name = name;
        this.price = price;
    }

    public MenuItem(String n, double p, String s, int q){
        this.name = n;
        this.price = p;
        this.size = s;
        this.quantity = q;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
