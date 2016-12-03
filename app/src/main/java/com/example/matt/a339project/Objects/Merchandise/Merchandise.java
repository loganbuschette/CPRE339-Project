package com.example.matt.a339project.Objects.Merchandise;

public interface Merchandise {

    double getSaleCost();

    double getRentalCost();

    int getFrequentCustomerPoints();

    String getItemTitle();

    int getFrequentCustomerPointCost();

    int getDaysRented();

    void setDaysRented(int daysRented);

    void appendMerchTypeToTitle();
}
