package com.example.matt.a339project.Objects.Merchandise.CD;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

/**
 * @author Logan
 */
public class CD implements Merchandise {

    private String CDTitle;
    protected int frequentCustomerPoints;
    protected int daysRented;

    public CD(String title){
        this.CDTitle = title;
        this.frequentCustomerPoints = 0;
    }

    public CD(String title, int daysRented){
        this.CDTitle = title;
        this.frequentCustomerPoints = 0;
        this.daysRented = daysRented;
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public double getSaleCost() {
        frequentCustomerPoints = 2;
        return 3;
    }

    @Override
    public double getRentalCost() {
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
