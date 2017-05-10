package com.example.linneabark.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.linneabark.test.R.id.errorMessage;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivity extends AppCompatActivity {

    static final int REGISTER_REQUEST_CODE = 1;

    EditText userName;
    EditText passWord;
    TextView eM; //errorMessage
    RadioButton rB; //keep the login
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);

        mContext = this;


        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);
        eM = (TextView) this.findViewById(R.id.errormessage_login);

        // displayUserInfo();


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!compareUserInfo()) { //if the password or username does not match

                    eM.setText("Password or username does not match!");

                } else {
                    AccountDetails.setKeepLoginState(mContext,rB); //see whether or not the radiobutton is checked(1 = true, 0 = false)
                    Intent LoginToMain = new Intent(LoginActivity.this, MainActivity.class);

                    startActivity(LoginToMain);
                    Toast.makeText(mContext, ("Logged in " + AccountDetails.getUsername(mContext) + "!"), Toast.LENGTH_LONG).show();


                }


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

    public boolean compareUserInfo() {

        if ((userName.getText().toString().equals(AccountDetails.getUsername(mContext))) && (passWord.getText().toString().equals(AccountDetails.getPassword(mContext)))) {
            return true;
        }

        return false;


    }

    //saves the current value of the radiobutton to be able to distinguish when to skip login view or not

}