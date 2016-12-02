package com.example.matt.a339project.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.R;

/**
 * Created by Logan on 11/16/2016.
 */

public class MovieActivity extends Activity {

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent i = getIntent();
        customer = (Customer)i.getSerializableExtra("customer");

        //set up book button to direct to book activity screen
        ImageButton bookButton = (ImageButton) findViewById(R.id.childrenMovie);
        bookButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), childrenMovieActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });

        //set up movies button to direct to movies activity screen
        ImageButton movieButton = (ImageButton) findViewById(R.id.newReleaseMovie);
        movieButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent myIntent = new Intent(view.getContext(), newReleaseMovieActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });

        //set up CD button to direct to CD activity screen
        ImageButton cdButton = (ImageButton) findViewById(R.id.regularMovie);
        cdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent myIntent = new Intent(view.getContext(), regularMovieActivity.class);
                myIntent.putExtra("customer", customer);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("customer",customer);
        setResult(RESULT_OK, intent);
        finish();
    }

}
