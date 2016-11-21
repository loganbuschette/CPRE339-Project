package com.example.matt.a339project.Objects.Merchandise.CD;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

/**
 * @author Logan
 */
public class CD implements Merchandise {

    private String CDTitle;
    protected int frequentCustomerPoints;

    public CD(String title){
        this.CDTitle = title;
        this.frequentCustomerPoints = 0;
    }

    @Override
    public double getSaleCost() {
        frequentCustomerPoints = 2;
        return 3;
    }

    @Override
    public double getRentalCost(int daysRented) {
        frequentCustomerPoints = 1;
        return daysRented/2;
    }

    @Override
    public int getFrequentCustomerPointCost(){
        return 10;
    }

    @Override
    public int getFrequentCustomerPoints() {
        return frequentCustomerPoints;
    }

    @Override
    public String getItemTitle() {
        return CDTitle;
    }
}
