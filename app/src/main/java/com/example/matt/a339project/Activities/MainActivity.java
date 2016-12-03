package com.example.matt.a339project.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.R;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    Firebase ref;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        customer = (Customer)i.getSerializableExtra("customer");

        //set up book button to direct to book activity screen
        ImageButton bookButton = (ImageButton) findViewById(R.id.books);
        bookButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BookActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });

        //set up movies button to direct to movies activity screen
        ImageButton movieButton = (ImageButton) findViewById(R.id.movies);
        movieButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent myIntent = new Intent(view.getContext(), MovieActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });

        //set up CD button to direct to CD activity screen
        ImageButton cdButton = (ImageButton) findViewById(R.id.cds);
        cdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent myIntent = new Intent(view.getContext(), CDActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.viewStatement);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), StatementActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if(resultCode == RESULT_OK){
                customer = (Customer) data.getSerializableExtra("customer");
            }
        }
    }
}
