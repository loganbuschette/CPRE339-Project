package com.example.matt.a339project.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.Objects.Merchandise.CD.CD;
import com.example.matt.a339project.R;
import com.firebase.client.Firebase;

/**
 * Created by Logan on 11/21/2016.
 */

public class CDActivity extends Activity {

    Firebase ref;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd);

        Intent i = getIntent();
        customer = (Customer)i.getSerializableExtra("customer");

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");

        String[] cds = getResources().getStringArray(R.array.cdArray);

        final ListView cdList = (ListView) findViewById(R.id.cdList);
        cdList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cds));

        final AlertDialog.Builder rentalBox = new AlertDialog.Builder(CDActivity.this);
        rentalBox.setTitle("Rental Period");
        rentalBox.setMessage("How long would you like to rent this item?");
        final NumberPicker np = new NumberPicker(CDActivity.this);
        String[] nums = new String[10];
        for(int j = 0; j<nums.length; j++)
        {
            nums[j] = Integer.toString(j);
        }
        np.setMinValue(0);
        np.setMaxValue(nums.length-1);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums);
        np.setValue(5);
        rentalBox.setView(np);
        rentalBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                //TODO
                int value = np.getValue();
                dialog.dismiss();
            }
        });
        rentalBox.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });

        final AlertDialog.Builder buyBox = new AlertDialog.Builder(CDActivity.this);
        buyBox.setTitle("Confirm Your Purchase");
        buyBox.setMessage("Are you sure you want to buy this item?");
        buyBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                //TODO
                dialog.dismiss();
            }
        });
        buyBox.setNegativeButton("No", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });

        cdList.setClickable(true);
        cdList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id){
                //if they click on it, add it to their statement
                AlertDialog acceptDialogBox = new AlertDialog.Builder(CDActivity.this)
                        //set message, title, and icon
                        .setTitle("Rent or Buy")
                        .setMessage("Do you want to rent or buy this item?")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("Rent", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                                rentalBox.show();
                            }
                        })
                        .setNegativeButton("Buy", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                                buyBox.show();
                            }
                        })
                        .create();
                acceptDialogBox.show();
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