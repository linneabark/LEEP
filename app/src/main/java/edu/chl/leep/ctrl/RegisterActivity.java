package edu.chl.leep.ctrl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linneabark.test.R;

import edu.chl.leep.model.RegisterActivityModel;
import edu.chl.leep.service.AccountDetails;

/**
 * Created by Eli on 2017-05-08.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText mail;
    private EditText userName;
    private EditText password;
    private EditText repeatPassword;
    private TextView errorMessage;
    private Button register;
    private Button backButton;

    Context mContext;
    RegisterActivityModel registerActivityModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        mContext = this;
        registerActivityModel = new RegisterActivityModel();

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

                registerActivityModel.comparePasswords(password, repeatPassword, errorMessage); //compare the written passwords
                registerActivityModel.checkEmail(mail, errorMessage); //check the email (if it's an email or not)

                if(!registerActivityModel.comparePasswords(password, repeatPassword, errorMessage) || !registerActivityModel.checkEmail(mail, errorMessage)){ //if the passwords does not match, the errormessages will tell


                } else{ //if everything is okay, save the information and finish the activity

                    // TODO User user = new User(name, email)
                    //MainActivity.leep.register(user);
                    //FilseSERVICE. SAVE
                    AccountDetails.setUSER(userName.getText().toString()); //sets the "user folder with the same name as username"

                    AccountDetails.setUsername(mContext, userName);
                    AccountDetails.setPassword(mContext, password);
                    AccountDetails.setEmail(mContext, mail);


                    Toast.makeText(mContext, "Account created!", Toast.LENGTH_SHORT).show();

                    finish();

                }


            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               finish();
            }
            });

    }


}
