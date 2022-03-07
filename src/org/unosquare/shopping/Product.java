package org.unosquare.shopping;

public class Product {
    private String name;
    private double price;

    public Product() {

    }
    public String getName() {
        return name;
    };

    public double getPrice() {
        return price;
    };

    public void setName(String nameForProduct){
        name = nameForProduct;
    };

    public void setPrice(double priceForProduct){
        price = priceForProduct;
    };
}
