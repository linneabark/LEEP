package com.example.linneabark.test;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;

public class AccountController extends AppCompatActivity {

    RootController rootC = new RootController();

    EditText mail = (EditText) this.findViewById(R.id.mail);
    EditText userName = (EditText) this.findViewById(R.id.setUserName);
    EditText password = (EditText) this.findViewById(R.id.setPassword);
    EditText repeatPassword = (EditText) this.findViewById(R.id.repeatPassword);
    RadioButton uterusBearer = (RadioButton)this.findViewById(R.id.uterusBearer);
    TextView errorMessage = (TextView) this.findViewById(R.id.errorMessage);
    Button register = (Button) this.findViewById(R.id.register);


    Editable myMail;
    Editable myUserName;
    Editable myPassword;
    boolean myUterusBearer;

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