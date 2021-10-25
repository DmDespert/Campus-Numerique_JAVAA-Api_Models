package com.ecommerce.microcommerce.model;

public class Product {
    private int id;
    private String model;
    private String marque;
    private String color;

    public Product(int id, String model, String marque, String color) {
        this.id = id;
        this.model = model;
        this.marque = marque;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{"+
                "id=" + id +
                ", model=" + model +
                ", marque=" + marque +
                ", couleur=" + color + "}";
    }
}
