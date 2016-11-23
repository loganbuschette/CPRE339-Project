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

import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.Objects.Merchandise.CD.CD;
import com.example.matt.a339project.R;
import com.firebase.client.Firebase;

/**
 * Created by Logan on 11/21/2016.
 */

public class CDActivity extends Activity {

    Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd);

        Intent i = getIntent();
        Customer customer = (Customer)i.getSerializableExtra("customer");

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");

        String[] cds = getResources().getStringArray(R.array.cdArray);

        final ListView cdList = (ListView) findViewById(R.id.cdList);
        cdList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cds));

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
                            }
                        })
                        .setNegativeButton("Buy", new DialogInterface.OnClickListener() {

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