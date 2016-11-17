package com.example.matt.a339project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

public class CD extends Activity {

    Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");

        String[] cds = getResources().getStringArray(R.array.cdArray);

        final ListView cdList = (ListView) findViewById(R.id.cdList);
        cdList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cds));

        cdList.setClickable(true);
        cdList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id){
                //if they click on it, add it to their statement
                //TODO
                AlertDialog acceptDialogBox = new AlertDialog.Builder(CD.this)
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
