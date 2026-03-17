package com.example.lab01;

import java.io.Serializable;

public class Bai82 implements Serializable {
    private String ten, gioitinh, que;
    private int avatar;

    public Bai82() {
    }

    public Bai82(String ten, String gioitinh, String que, int avatar) {
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.que = que;
        this.avatar = avatar;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Bai82{" +
                "ten='" + ten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", que='" + que + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}