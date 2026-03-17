package com.example.myapplication;

import java.io.Serializable;

public class Football implements Serializable {
    private String fullname;
    private String address;
    private int avatar;
    private int flag;

    public Football() {
    }

    public Football(String fullname, String address, int avatar, int flag) {
        this.fullname = fullname;
        this.address = address;
        this.avatar = avatar;
        this.flag = flag;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getAddress() {
        return address;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "Football{" +
                "fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", avatar=" + avatar +
                ", flag=" + flag +
                '}';
    }
}
