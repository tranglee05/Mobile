package com.example.lab01;

import java.io.Serializable;

public class Bai9 implements Serializable {
    private String ten, gioitinh, des;
    private boolean vb;
    private int avatar;


    public Bai9() {
    }
    public Bai9(String ten, String gioitinh, String des, boolean vb, int avatar) {
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.des = des;
        this.vb = vb;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isVb() {
        return vb;
    }

    public void setVb(boolean vb) {
        this.vb = vb;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Bai9{" +
                "ten='" + ten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", des='" + des + '\'' +
                ", vb=" + vb +
                ", avatar=" + avatar +
                '}';
    }
}
