package com.example.matt.a339project.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.Objects.Merchandise.Movie.Movie_Regular;
import com.example.matt.a339project.R;
import com.firebase.client.Firebase;

public class regularMovieActivity extends AppCompatActivity {

    Firebase ref;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_movie);

        Intent i = getIntent();
        customer = (Customer)i.getSerializableExtra("customer");

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");

        String[] movies = getResources().getStringArray(R.array.regularMovieArray);

        final ListView movieList = (ListView) findViewById(R.id.regMovieList);
        movieList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies));

        movieList.setClickable(true);
        movieList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id){
                //if they click on it, add it to their statement
                final String movie = (String) arg0.getAdapter().getItem(position);
                AlertDialog acceptDialogBox = new AlertDialog.Builder(regularMovieActivity.this)
                        //set message, title, and icon
                        .setTitle("Rent or Buy")
                        .setMessage("Do you want to rent or buy this item?")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("Rent", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                                RequestRentalDays(movie);
                            }
                        })
                        .setNegativeButton("Buy", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                                Purchase(movie);
                            }
                        })
                        .create();
                acceptDialogBox.show();
            }
        });
    }

    private void RequestRentalDays(String movie){
        final String title = movie;
        final AlertDialog.Builder rentalBox = new AlertDialog.Builder(regularMovieActivity.this);
        rentalBox.setTitle("Rental Period");
        rentalBox.setMessage("How many days would you like to rent this item?");
        final NumberPicker np = new NumberPicker(regularMovieActivity.this);
        String[] nums = new String[10];
        for(int j = 0; j<nums.length; j++)
        {
            nums[j] = Integer.toString(j+1);
        }
        np.setMinValue(1);
        np.setMaxValue(nums.length);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums);
        np.setValue(5);
        rentalBox.setView(np);
        rentalBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                customer.addRental(new Movie_Regular(title, np.getValue()));
                dialog.dismiss();
            }
        });
        rentalBox.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        rentalBox.show();
    }

    private void Purchase(String movie){
        final String title = movie;
        final AlertDialog.Builder buyBox = new AlertDialog.Builder(regularMovieActivity.this);
        buyBox.setTitle("Confirm Your Purchase");
        buyBox.setMessage("Are you sure you want to buy this item?");
        buyBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                customer.addPurchase(new Movie_Regular(title));
                dialog.dismiss();
            }
        });
        buyBox.setNegativeButton("No", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        buyBox.show();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("customer",customer);
        setResult(RESULT_OK, intent);
        finish();
    }
}
