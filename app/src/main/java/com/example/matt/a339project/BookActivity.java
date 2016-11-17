package com.example.matt.a339project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

/**
 * Created by Logan on 11/16/2016.
 */

public class BookActivity extends Activity {

    Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");

        String[] books = getResources().getStringArray(R.array.bookArray);

        final ListView bookList = (ListView) findViewById(R.id.bookList);
        bookList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books));

        bookList.setClickable(true);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id){
                //if they click on it, add it to their statement
                //TODO
                AlertDialog acceptDialogBox = new AlertDialog.Builder(BookActivity.this)
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
