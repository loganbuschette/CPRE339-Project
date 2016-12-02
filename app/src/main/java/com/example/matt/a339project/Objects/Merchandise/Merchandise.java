package com.example.matt.a339project.Objects.Merchandise;

import java.io.Serializable;

/**
 * Created by Matt on 11/16/2016.
 */

public interface Merchandise {

    double getSaleCost();

    int getFrequentCustomerPointCost();

    double getRentalCost();

    int getFrequentCustomerPoints();

    String getItemTitle();

    int getDaysRented();

    void setDaysRented(int daysRented);

    void appendMerchTypeToTitle();
}
