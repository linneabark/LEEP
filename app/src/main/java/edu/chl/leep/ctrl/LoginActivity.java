package edu.chl.leep.ctrl;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linneabark.test.R;

import edu.chl.leep.service.AccountDetails;

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

        //TODO new Leep();
        //Måste kunna kommas åt i hela programmet, sätt public static

        mContext = this;

        if(AccountDetails.getKeepLoginState(mContext) == 1){

            AccountDetails.setUSER(AccountDetails.getPreviousUser(mContext));

            Intent toy = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(toy);

        }

        Button registerButton = (Button) this.findViewById(R.id.registerButton);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);
        eM = (TextView) this.findViewById(R.id.errormessage_login);

        System.out.println(AccountDetails.getKeepLoginState(mContext));



        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!compareUserInfo()) { //if the password or username does not match

                    eM.setText("Password or username does not match!");

                } else {

                    AccountDetails.setKeepLoginState(mContext,rB);//see whether or not the radiobutton is checked(1 = true, 0 = false)

                    Intent LoginToMain = new Intent(LoginActivity.this, MainActivity.class);

                    AccountDetails.setPreviousUser(mContext, AccountDetails.getUSER());

                    startActivity(LoginToMain);
                    Toast.makeText(mContext, ("Logged in " + AccountDetails.getUsername(mContext) + "!"), Toast.LENGTH_LONG).show();


                }

                System.out.println(AccountDetails.getKeepLoginState(mContext));


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

        AccountDetails.setUSER(userName.getText().toString());

        if ((AccountDetails.getUSER().equals(AccountDetails.getUsername(mContext))) && (passWord.getText().toString().equals(AccountDetails.getPassword(mContext)))) {
            return true;
        }

        return false;

    }

}