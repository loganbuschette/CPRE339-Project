package com.example.matt.a339project.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.matt.a339project.Controller;
import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.Objects.Merchandise.Book.Book;
import com.example.matt.a339project.Objects.Merchandise.CD.CD;
import com.example.matt.a339project.Objects.Merchandise.Movie.Movie;
import com.example.matt.a339project.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase ref;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

//        if (pref.getString("user", null) == null) {
//            Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivityForResult(myIntent, 0);
//            finish();
//        }

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
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem item = menu.findItem(R.id.homeBtn);
//        MenuItem item2 = menu.findItem(R.id.backBtn);
//        item.setVisible(false);
//        item2.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
//            case R.id.action_settings:
//                return true;
//            case R.id.logoutBtn:
//                ref.unauth();
//                startActivity(new Intent(this, LoginActivity.class));
//                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
