package com.example.matt.a339project.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.matt.a339project.Controller;
import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.R;
import com.firebase.client.Firebase;

public class FirstActivity extends AppCompatActivity {

    Firebase ref;
    Customer customer = new Customer();

    int one = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://blinding-torch-3840.firebaseio.com");
        setContentView(R.layout.activity_first);

        Button createUser = (Button) findViewById(R.id.customerInfoButton);
        createUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText tempName = (EditText) findViewById(R.id.textPersonName);
                String name = tempName.getText().toString();

                EditText tempEmail = (EditText) findViewById(R.id.textPersonEmail);
                String email = tempEmail.getText().toString();

                EditText tempAge = (EditText) findViewById(R.id.textPersonAge);
                String age = tempAge.getText().toString();

                if(name.matches(""))
                {
                    AlertDialog acceptDialogBox = new AlertDialog.Builder(FirstActivity.this)
                            //set message, title, and icon
                            .setTitle("Error")
                            .setMessage("Please Enter a Name")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    acceptDialogBox.show();
                }
                else if(email.matches("") || !email.toString().contains("@"))
                {
                    AlertDialog acceptDialogBox = new AlertDialog.Builder(FirstActivity.this)
                            //set message, title, and icon
                            .setTitle("Error")
                            .setMessage("Please Enter a Valid Email")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    acceptDialogBox.show();
                }
                else if(age.matches("") || Integer.parseInt(age) < 0 || Integer.parseInt(age) > 100)
                {
                    AlertDialog acceptDialogBox = new AlertDialog.Builder(FirstActivity.this)
                            //set message, title, and icon
                            .setTitle("Error")
                            .setMessage("Please Enter an Age between 0-100")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    acceptDialogBox.show();
                }
                else{
                    Controller.factory().name = name.toString();
                    Controller.factory().email = email.toString();
                    Controller.factory().age = age.toString();

                    customer.setName(name.toString());
                    customer.setEmail(email.toString());
                    customer.setAge(age.toString());

                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    myIntent.putExtra("customer", customer);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
