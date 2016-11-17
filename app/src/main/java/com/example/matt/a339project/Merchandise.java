package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public abstract class Merchandise {

    private String itemName;

    public Merchandise(String itemName) {
        this.itemName = itemName;
    }

    public abstract double getSaleCost();

    public abstract double getRentalCost(int daysRented);

    public abstract int getFrequentCustomerPoints(int daysRented);

    public String getItemName() {
        return itemName;
    }
}
