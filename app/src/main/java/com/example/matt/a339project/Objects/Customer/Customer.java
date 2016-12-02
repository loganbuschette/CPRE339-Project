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
    private String age;
    private String email;
    private ArrayList<Merchandise> rentals = new ArrayList<Merchandise>();
    private ArrayList<Merchandise> purchases = new ArrayList<Merchandise>();
    private int frequentCustomerPoints;

    public Customer (String name, String age, String email, int frequentCustomerPoints) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.frequentCustomerPoints = frequentCustomerPoints;
    }

    public Customer() {}

    public void setName(String name) {this.name = name;}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {this.age = age; }

    public int getFrequentCustomerPoints(){
        return frequentCustomerPoints;
    }

    public void addRental(Merchandise rental){
        rentals.add(rental);
    }

    public void addPurchase(Merchandise purchase){
        purchases.add(purchase);
    }

}
