package com.example.linneabark.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;

public class AccountController extends AppCompatActivity {
    Editable myMail;
    Editable myUserName;
    Editable myPassword;
    boolean myUterusBearer;

    private EditText mail;
    private EditText userName;
    private EditText password;
    private EditText repeatPassword;
    private RadioButton uterusBearer;
    private TextView errorMessage;
    private Button register;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.register, container, false);
        mail = (EditText) rootView.findViewById(R.id.mail);
        userName = (EditText) rootView.findViewById(R.id.setUserName);
        password = (EditText) rootView.findViewById(R.id.setPassword);
        repeatPassword = (EditText) rootView.findViewById(R.id.repeatPassword);
        uterusBearer = (RadioButton)rootView.findViewById(R.id.uterusBearer);
        errorMessage = (TextView) rootView.findViewById(R.id.errorMessage);
        register = (Button) rootView.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createAccount();
            }
        });

        return rootView;
    }


    //trying to make clock with threads

    RootController rootC = new RootController();


    public void createAccount() {
        setMail();
        setUserName();
        boolean ok = setPassword();
        setUterusCarrier();

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

    private void setUterusCarrier() {
        myUterusBearer = uterusBearer.isSelected();
    }

}