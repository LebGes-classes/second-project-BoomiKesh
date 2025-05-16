package org.example;

public class Product {
    private String name;
    private int amount;
    private int price;

    public Product(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public String getName(){
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
