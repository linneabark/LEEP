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
    boolean myUterusBearer;

    private EditText mail;
    private EditText userName;
    private EditText password;
    private EditText repeatPassword;
    private RadioButton uterusBearer;
    private TextView errorMessage;
    private Button register;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){

        if(requestCode == REGISTER_REQUEST_CODE ){

            //make sure the request was succesfull

            if(resultCode == RESULT_OK){

            }
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mail = (EditText) this.findViewById(R.id.mail);
        userName = (EditText) this.findViewById(R.id.setUserName);
        password = (EditText) this.findViewById(R.id.setPassword);
        repeatPassword = (EditText) this.findViewById(R.id.repeatPassword);
        uterusBearer = (RadioButton)this.findViewById(R.id.uterusBearer);
        errorMessage = (TextView) this.findViewById(R.id.errorMessage);
        register = (Button) this.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                okCreateAccount();
            }
        });
    }

    AccountCheck accountCheck = new AccountCheck();

    public void createAccount() {
        String useRname = userName.getText().toString();
        String eMail = mail.getText().toString();
        String passworD = password.getText().toString();

        new CreateAccount(useRname, eMail, passworD);
    }

    public void okCreateAccount() {
        boolean checkPassword = accountCheck.checkPassword(mail.getText().toString(), repeatPassword.getText().toString());
        boolean checkMail = accountCheck.checkMail(mail.toString());

        if (!checkPassword) {
            errorMessage.setText("Check the password, they don't match!");
        }
        else if (!checkMail) {
            errorMessage.setText("Please correct mail");
        }
        else {
            errorMessage.setText("");
            createAccount();
        }
    }

    private void setMail() {
        myMail = mail.getText();
    }

    private void setUserName() {
        myUserName = userName.getText();
    }

    private void setPassword() {
        myPassword = password.getText();
    }

    private void setUterusCarrier() {
        myUterusBearer = uterusBearer.isSelected();
    }



}
