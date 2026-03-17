package com.example.lab03;

public class Music {
    private String name;
    private String singer;
    private String time;
    private int avatar;

    public Music() {
    }

    public Music(String name, String singer, String time, int avatar) {
        this.name = name;
        this.singer = singer;
        this.time = time;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", time='" + time + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
