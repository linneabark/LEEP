package com.example.linneabark.test;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.linneabark.test.R.id.loginButton;
import static com.example.linneabark.test.R.id.my_toolbar;

public class MainActivity extends AppCompatActivity {

    //private AccountController account = new AccountController();

    private int value;
    Context mContext;


    public boolean checkValueOfRadioButton() {

        SharedPreferences sharedPreferences = getSharedPreferences("Clicked_RadioButton", Context.MODE_PRIVATE);

        int value = sharedPreferences.getInt("RadioButton", 0);

        if (value == 1) {
            return true;
        }
        return false;

        //change this to true if you want to be able to access the original layout (with toolbar etc)
    }

    public boolean alreadyAUser() {

        return false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;


        //if the value is 0 start login in again
            if(checkValueOfRadioButton()){

                Intent toy = new Intent(MainActivity.this, MainActivity.class);
                startActivity(toy);
        }


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        //MenuItem logOut = getItemId(R.id.account_id);


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment nextFrag = new Fragment();
        switch (item.getItemId()){
            case R.id.settings_id:
                nextFrag = new Settings();
                break;
            case R.id.statistics_id:
                nextFrag = new Statistics();
                break;
            case R.id.timelog_id:
                nextFrag = new TimeLog();
                break;
            case R.id.account_id:
                Toast.makeText(mContext, ("Logged out " + AccountDetails.getUsername(mContext)+"!"),Toast.LENGTH_LONG).show();

                Intent toy = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(toy);

        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }


}
