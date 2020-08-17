package com.example.beerstore;

public class ModelData {
    private String name,address;
    private String quantitiy,number;
    private int id;

    public ModelData(String name, String address, String quantitiy, String number, int id) {
        this.name = name;
        this.address = address;
        this.quantitiy = quantitiy;
        this.number = number;
        this.id = id;
    }

    public ModelData() {
    }

    @Override
    public String toString() {
        return "ModelData{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", quantitiy=" + quantitiy +
                ", number=" + number +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(String quantitiy) {
        this.quantitiy = quantitiy;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
