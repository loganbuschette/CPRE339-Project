package com.example.matt.a339project.Objects.Customer;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;
import com.example.matt.a339project.Objects.Transaction.Transaction;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Matt on 11/16/2016.
 */

@SuppressWarnings("serial")
public class Customer implements Serializable {
    private String name;
    private int age;
    private ArrayList<Merchandise> rentals = new ArrayList<Merchandise>();
    private ArrayList<Merchandise> purchases = new ArrayList<Merchandise>();
    private int frequentCustomerPoints;

    public Customer (String name, int age, int frequentCustomerPoints) {
        this.name = name;
        this.age = age;
        this.frequentCustomerPoints = frequentCustomerPoints;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFrequentCustomerPoints(){
        return frequentCustomerPoints;
    }

}
