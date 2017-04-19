package com.example.linneabark.test;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
<<<<<<< HEAD
=======
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
>>>>>>> origin/master

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
<<<<<<< HEAD
    public boolean onCreateOptionsMenu(Menu menu){
=======
    public boolean onCreateOptionsMenu(final Menu menu){
>>>>>>> origin/master

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;

<<<<<<< HEAD
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings_id:
                setContentView(R.layout.settings_view);
                return true;
            case R.id.statistics_id:
                setContentView(R.layout.statistics_view);
                return true;
            case R.id.timelog_id:
                setContentView(R.layout.activity_main);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void testMethod(){
        int i = 6;
=======

>>>>>>> origin/master

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
        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }


}
