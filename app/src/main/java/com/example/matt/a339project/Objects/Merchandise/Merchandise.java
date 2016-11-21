package com.example.matt.a339project.Objects.Merchandise;

/**
 * Created by Matt on 11/16/2016.
 */

public interface Merchandise {

    double getSaleCost();

    int getFrequentCustomerPointCost();

    double getRentalCost(int daysRented);

    int getFrequentCustomerPoints();

    String getItemTitle();
}
