package com.example.linneabark.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);

        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent toy = new Intent(LoginActivity.this, MainActivity.class);

                startActivity(toy);

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
}
