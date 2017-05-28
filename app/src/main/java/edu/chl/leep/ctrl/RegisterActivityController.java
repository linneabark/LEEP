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

import edu.chl.leep.model.RegisterActivityModel;
import edu.chl.leep.model.UserModel;

/**
 * Created by Eli on 2017-05-08.
 * Is the controller class which handles the register view
 */

public class RegisterActivityController extends AppCompatActivity {
    private EditText mail;
    private EditText userName;
    private EditText password;
    private EditText repeatPassword;
    private TextView errorMessage;
    private Button register;
    private Button backButton;
    public static UserModel newUser;
    private Context mContext;
    private RegisterActivityModel registerActivityModel;

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

                if(!registerActivityModel.comparePasswords(password, repeatPassword, errorMessage)
                        || !registerActivityModel.checkEmail(mail, errorMessage)){

                } else{

                    newUser = new UserModel(
                            userName.getText().toString(),
                            userName.getText().toString(),
                            mail.getText().toString(),
                            password.getText().toString(),
                            mContext);

                    MainActivityController.leep.register();
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
