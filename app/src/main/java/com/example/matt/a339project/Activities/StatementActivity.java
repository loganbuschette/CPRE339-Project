package com.example.matt.a339project.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matt.a339project.Adapters.PurchaseListAdapter;
import com.example.matt.a339project.Adapters.RentalListAdapter;
import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.Objects.Merchandise.Merchandise;
import com.example.matt.a339project.R;

import java.text.NumberFormat;
import java.util.List;

public class StatementActivity extends AppCompatActivity {

    Customer customer;
    private ListView rentalsLV;
    private ListView purchaseLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        Intent i = getIntent();
        customer = (Customer)i.getSerializableExtra("customer");

        TextView name = (TextView) findViewById(R.id.customerName);
        name.setText(customer.getName());

        TextView age = (TextView) findViewById(R.id.customerAge);
        age.setText(customer.getAge());

        customer.addMerchTypeToRentals();
        customer.addMerchTypeToPurchases();


        rentalsLV = (ListView) findViewById(R.id.rentalList);
        RentalListAdapter rentalAdapter = new RentalListAdapter(this, R.layout.statement_item, customer.getRentals());
        rentalsLV.setAdapter(rentalAdapter);

        purchaseLV = (ListView) findViewById(R.id.purchaseList);
        PurchaseListAdapter purchaseAdapter = new PurchaseListAdapter(this, R.layout.statement_item, customer.getPurchases());
        purchaseLV.setAdapter(purchaseAdapter);

        double totalPrice = 0;
        int totalFRP = 0;
        for(Merchandise item : customer.getRentals()){
            totalPrice += item.getRentalCost();
            totalFRP += item.getFrequentCustomerPoints();
        }
        for(Merchandise item : customer.getPurchases()){
            totalPrice += item.getSaleCost();
            totalFRP += item.getFrequentCustomerPoints();
        }

        TextView totalCost = (TextView) findViewById(R.id.totalAmount);
        NumberFormat format = NumberFormat.getCurrencyInstance();
        totalCost.setText(format.format(totalPrice));

        TextView FRP = (TextView) findViewById(R.id.fqrAmount);
        FRP.setText(""+totalFRP);

        //TODO push list to DB on checkout


        Button clearButton = (Button) findViewById(R.id.clearBtn);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog clearBox = new AlertDialog.Builder(StatementActivity.this)
                        //set message, title, and icon
                        .setTitle("Clear Shopping Cart")
                        .setMessage("Would you like to clear your shopping cart?")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                //TODO clear customer list
                                Intent myIntent = new Intent(StatementActivity.this, FirstActivity.class);
                                startActivityForResult(myIntent, 0);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                clearBox.show();
            }
        });


        Button checkoutButton = (Button) findViewById(R.id.checkoutBtn);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog acceptDialogBox = new AlertDialog.Builder(StatementActivity.this)
                        //set message, title, and icon
                        .setTitle("Frequent Renter Points")
                        .setMessage("Would you like to use your frequent renter points?")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("Yes and Pay", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                //TODO push list to firebase, subtract renter points and clear list
                                Intent myIntent = new Intent(StatementActivity.this, FirstActivity.class);
                                startActivityForResult(myIntent, 0);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No and Pay", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                //TODO clear customer list
                                Intent myIntent = new Intent(StatementActivity.this, FirstActivity.class);
                                startActivityForResult(myIntent, 0);
                                dialog.dismiss();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                acceptDialogBox.show();
            }
        });
    }
}
