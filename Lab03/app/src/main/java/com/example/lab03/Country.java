package com.example.lab03;

public class Country {
    private int avatar;
    private String name;
    private String population;
    private String area;

    public Country() {
    }

    public Country(int avatar, String name, String population, String area) {
        this.avatar = avatar;
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Country{" +
                "avatar=" + avatar +
                ", name='" + name + '\'' +
                ", population='" + population + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
