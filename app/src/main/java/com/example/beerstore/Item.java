package com.example.beerstore;

public class Item {

    private String alchohalName;
    private String alchohalPrice;
    private Integer alchohalImage;


    public Item(String alchohalName, String alchohalPrice, Integer alchohalImage) {
        this.alchohalName = alchohalName;
        this.alchohalPrice = alchohalPrice;
        this.alchohalImage = alchohalImage;
    }

    public String getAlchohalName() {
        return alchohalName;
    }

    public void setAlchohalName(String alchohalName) {
        this.alchohalName = alchohalName;
    }

    public String getAlchohalPrice() {
        return alchohalPrice;
    }

    public void setAlchohalPrice(String alchohalPrice) {
        this.alchohalPrice = alchohalPrice;
    }

    public int getAlchohalImage() {
        return alchohalImage;
    }

    public void setAlchohalImage(Integer alchohalImage) {
        this.alchohalImage = alchohalImage;
    }
}
