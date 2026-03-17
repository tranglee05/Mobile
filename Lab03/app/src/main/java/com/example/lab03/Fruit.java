package com.example.lab03;

import android.widget.ImageView;
import android.widget.TextView;

public class Fruit {
    private String Name, Des;
    private int avatar;

    public Fruit() {
    }

    public Fruit(String name, String des, int avatar) {
        Name = name;
        Des = des;
        this.avatar = avatar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "Name='" + Name + '\'' +
                ", Des='" + Des + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
