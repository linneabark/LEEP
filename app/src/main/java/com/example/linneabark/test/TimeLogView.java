package com.example.linneabark.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;

/**
 * Created by Eli on 2017-04-14.
 */

public class TimeLogView extends AppCompatActivity {

    TextView clock_txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView clock_txt = (TextView) findViewById(R.id.clock_txt);
        Button startActivity = (Button) findViewById(R.id.startActivity_button);
        Button stopActivity = (Button) findViewById(R.id.stopActivity_button);

        startActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //clock_txt.setText());
                // Do something in response to button click
            }
        });
        stopActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });
    }

    public TimeLogView (){

    }
}
