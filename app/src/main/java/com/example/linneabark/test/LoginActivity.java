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
    TextView eM;
    RadioButton rB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);


        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);
        eM = (TextView) this.findViewById(R.id.errormessage_login);

       // displayUserInfo();

        final Intent switchToMain = new Intent(LoginActivity.this, MainActivity.class);



        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(!compareUserInfo()){ //if the password or username does not match

                    eM.setText("Password or username does not match!");

                }else{
                    checkStateOfRadioButton();
                    saveValueOfRadioButton();

                    startActivity(switchToMain);
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

    public void displayUserInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("Username", "");
        String password = sharedPreferences.getString("Password", "");

        userName.setText(username);
        passWord.setText(password);

    }

    public boolean compareUserInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("Username", "");
        String password = sharedPreferences.getString("Password", "");

        if((userName.getText().toString().equals(username)) && (passWord.getText().toString().equals(password))){
            return true;
        }

        return false;


    }

    //saves the current value of the radiobutton to be able to distinguish when to skip login view or not

    public void saveValueOfRadioButton() {

        SharedPreferences sharedPreferences = getSharedPreferences("Clicked_RadioButton", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(checkStateOfRadioButton()){
            editor.putInt("RadioButton", 1);
        }else{
            editor.putInt("RadioButton", 0);
        }
        editor.apply();

        Toast.makeText(this, "Radio button checked or not!", Toast.LENGTH_LONG).show();


    }

    //checks whether or not the radiobutton is clicked

    private boolean checkStateOfRadioButton()
    {

        boolean checked = rB.isChecked();

       if (checked){
           return true;
       }
        return false;
    }
}
