package com.example.linneabark.test;

import android.content.Intent;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mail = (EditText) this.findViewById(R.id.mail);
        userName = (EditText) this.findViewById(R.id.setUserName);
        password = (EditText) this.findViewById(R.id.setPassword);
        repeatPassword = (EditText) this.findViewById(R.id.repeatPassword);
        errorMessage = (TextView) this.findViewById(R.id.errorMessage);
        register = (Button) this.findViewById(R.id.register);
        backButton = (Button) this.findViewById(R.id.backButton);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createAccount();

                //if the creation of the account was correct
                finish();
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




     RootController rootC = new RootController();


    public void createAccount() {
        setMail();
        setUserName();
        boolean ok = setPassword();

        if (!ok) {
            errorMessage.setText("Lösenordet stämmer inte överens!");
        }
        else {
            rootC.switchToLog();
        }
    }

    private void setMail() {
        myMail = mail.getText();
    }

    private void setUserName() {
        myUserName = userName.getText();
    }

    private boolean setPassword() throws IllegalArgumentException {
        if (password.getText() == repeatPassword.getText()) {
            myPassword = password.getText();
            return true;
        }
        return false;
    }


}
