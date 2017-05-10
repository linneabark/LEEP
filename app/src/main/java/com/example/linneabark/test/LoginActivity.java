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
import android.widget.Toast;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivity extends AppCompatActivity {

    static final int REGISTER_REQUEST_CODE = 1;

    EditText userName;
    EditText passWord;
    RadioButton rB;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);

        view = new View(this);


        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);


        displayData();

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent toy = new Intent(LoginActivity.this, MainActivity.class);
                checkValueOfRadioButton();
                saveValueOfRadioButton();

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

    public void displayData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("Username", "");
        String password = sharedPreferences.getString("Password", "");

        userName.setText(username);
        passWord.setText(password);

    }

    //saves the current value of the radiobutton to be able to distinguish when to skip login view or not

    public void saveValueOfRadioButton() {

        SharedPreferences sharedPreferences = getSharedPreferences("Clicked_RadioButton", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(checkValueOfRadioButton()){
            editor.putInt("RadioButton", 1);
        }else{
            editor.putInt("RadioButton", 0);
        }
        editor.apply();

        Toast.makeText(this, "Radio button checked or not!", Toast.LENGTH_LONG).show();


    }

    //checks wether or not the radiobutton is clicked

    private boolean checkValueOfRadioButton()
    {

        boolean checked = rB.isChecked();

       if (checked){
           return true;
       }
        return false;
    }
}
