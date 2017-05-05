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
import android.widget.Button;

import static com.example.linneabark.test.R.id.loginButton;


public class MainActivity extends AppCompatActivity {

    private RootController rootC = new RootController();
    private AccountController account = new AccountController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);
        Button register = (Button) this.findViewById(R.id.register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rootC.switchToLog();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rootC.switchToRegister();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                account.createAccount();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;


    }




    private void testMethod(){
        int i = 6;


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
