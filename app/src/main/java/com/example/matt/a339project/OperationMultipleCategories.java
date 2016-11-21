package com.example.matt.a339project;

import com.example.matt.a339project.Objects.Transaction.Transaction;
import com.example.matt.a339project.Objects.Merchandise.Transactions;

import java.util.HashSet;

/**
 * Created by Matt on 11/16/2016.
 */

public class OperationMultipleCategories implements EndSaleStrategy{
    @Override
    public void applyAction(Transactions transactions) {
        HashSet<Object> categories = new HashSet<>();

        for(Transaction t : transactions.getCollection()) {
            categories.add(t.getMerchandise().getClass());
        }

        if (categories.size() > 2) {
            transactions.bonusFrequentCustomerPoints = transactions.getTotalFrequentCustomerPoints();
        }
    }
}
