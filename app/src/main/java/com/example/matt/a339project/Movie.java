package com.example.matt.a339project;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

public class Movie extends Merchandise {
    public Movie(String itemName) {
        super(itemName);
    }

    @Override
    public double getSaleCost() {
        return 0;
    }

    @Override
    public double getRentalCost(int daysRented) {
        return 0;
    }

    @Override
    public int getFrequentCustomerPoints(int daysRented) {
        return 0;
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }
}
