package com.example.matt.a339project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        TextView name = (TextView) findViewById(R.id.customerName);
        name.setText(Controller.factory().name);

        TextView age = (TextView) findViewById(R.id.customerAge);
        age.setText(String.valueOf(Controller.factory().age));
    }
}
