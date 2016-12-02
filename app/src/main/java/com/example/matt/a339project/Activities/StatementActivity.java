package com.example.matt.a339project.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.matt.a339project.Controller;
import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.R;

public class StatementActivity extends AppCompatActivity {

    Customer customer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        TextView name = (TextView) findViewById(R.id.customerName);
        name.setText(Controller.factory().name.toString());

        TextView age = (TextView) findViewById(R.id.customerAge);
        age.setText(String.valueOf(Controller.factory().age.toString()));

        //TODO set the all of the summaries text

        Intent i = getIntent();
        customer = (Customer)i.getSerializableExtra("customer");

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
