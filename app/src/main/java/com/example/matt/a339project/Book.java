package com.example.matt.a339project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Collections;

public class Book extends Merchandise {

    public Book(String itemName) {super(itemName);}

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
