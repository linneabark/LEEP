package com.example.linneabark.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivity extends AppCompatActivity {

static final int REGISTER_REQUEST_CODE = 1;

    EditText userName;
    EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);

        //displayData();

        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent toy = new Intent(LoginActivity.this, MainActivity.class);

                startActivityForResult(toy,REGISTER_REQUEST_CODE);

            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(toy);

            }
        });

    }

    public void displayData(){
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("Username", "");
        String email = sharedPreferences.getString("Email", "");
        String password = sharedPreferences.getString("Password", "");

        /*userName.setText(username);
        passWord.setText(password);*/

    }
}
