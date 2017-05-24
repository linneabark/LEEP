package edu.chl.leep.ctrl;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linneabark.test.R;

import edu.chl.leep.model.Leep;
import edu.chl.leep.model.User;
import edu.chl.leep.service.FileService;

/**
 * Created by Eli on 2017-05-08.
 */

public class RegisterActivity extends AppCompatActivity {
    //TODO change name to RegisterActivityCtrl

    private EditText mail;
    private EditText userName;
    private EditText password;
    private EditText repeatPassword;
    private TextView errorMessage;
    private Button register;
    private Button backButton;
    public static User newUser;

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

                comparePasswords(password, repeatPassword, errorMessage); //compare the written passwords
                checkEmail(mail, errorMessage); //check the email (if it's an email or not)

                if(!comparePasswords(password, repeatPassword, errorMessage) || !checkEmail(mail, errorMessage)){ //if the passwords does not match, the errormessages will tell


                } else{ //if everything is okay, save the information and finish the activity

                    // TODO User user = new User(name, email)
                    //MainActivity.leep.register(user);
                    //FilseSERVICE. SAVE

                    newUser = new User(
                            userName.getText().toString(),
                            userName.getText().toString(),
                            mail.getText().toString(),
                            password.getText().toString(),
                            mContext);

                    MainActivity.leep.register();

                    //Ändra till User
/*
                    Leep.setUSER(userName.getText().toString()); //sets the "user folder with the same name as username"
                    Leep.setUsername(mContext, userName.getText().toString());
                    Leep.setPassword(mContext, password.getText().toString());
                    Leep.setEmail(mContext, mail.getText().toString());

*/
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

    public boolean comparePasswords(EditText password, EditText repeatPassword, TextView errorMessage) { //compares passwords before saving them (compares the two edittext-fields
        if (password.getText().toString().equals(repeatPassword.getText().toString())) {
            return true;
        }
        errorMessage.setText("Passwords does not match!");
        return false;
    }

    public boolean checkEmail(EditText mail, TextView errorMessage){ //checks the email in the edittext-field
        if((mail.getText().toString().contains("@")) && (mail.getText().toString().contains("."))){
            return true;

        }
        errorMessage.setText("Not a valid email!");
        return false;

    }


}
