package com.example.linneabark.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.linneabark.test.LoginActivity.REGISTER_REQUEST_CODE;

/**
 * Created by Eli on 2017-05-08.
 */

public class RegisterActivity extends AppCompatActivity {

    Editable myMail;
    Editable myUserName;
    Editable myPassword;

    private EditText mail;
    private EditText userName;
    private EditText password;
    private EditText repeatPassword;
    private TextView errorMessage;
    private Button register;
    private Button backButton;

    Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mContext = this;

        mail = (EditText) this.findViewById(R.id.mail);
        userName = (EditText) this.findViewById(R.id.setUserName);
        password = (EditText) this.findViewById(R.id.setPassword);
        repeatPassword = (EditText) this.findViewById(R.id.repeatPassword);
        errorMessage = (TextView) this.findViewById(R.id.errorMessage);
        register = (Button) this.findViewById(R.id.register);
        backButton = (Button) this.findViewById(R.id.backButton);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                //if the creation of the account was correct finish activity and save user info

                comparePasswords();
                checkEmail();

                if(!comparePasswords() || !checkEmail()){


                } else{
                    //saveInfo();

                    AccountDetails.setUsername(mContext, userName);
                    AccountDetails.setPassword(mContext,password);
                    AccountDetails.setEmail(mContext, mail);

                    finish();

                }


            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //if we want the view to go to the start of the program directly after register

                Intent toy = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(toy);




            }
        });
    }

    //save user's login info

    /*public void saveInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Username", userName.getText().toString());
        editor.putString("Email", mail.getText().toString());
        editor.putString("Password", password.getText().toString());
        editor.apply();

        Toast.makeText(this, "Account created!", Toast.LENGTH_LONG).show();

    }**/




    private boolean comparePasswords() {
        if (password.getText().toString().equals(repeatPassword.getText().toString())) {
            return true;
        }
        errorMessage.setText("Passwords does not match!");
        return false;
    }

    private boolean checkEmail(){
        if((mail.getText().toString().contains("@")) && (mail.getText().toString().contains("."))){
            return true;

        }
        errorMessage.setText("Not a valid email!");
        return false;

    }

}
