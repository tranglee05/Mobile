package com.example.lab03;

public class Clothes {
    private String name;
    private String price;
    private int img;

    public Clothes() {
    }

    public Clothes(String name, String price, int img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", img=" + img +
                '}';
    }
}
