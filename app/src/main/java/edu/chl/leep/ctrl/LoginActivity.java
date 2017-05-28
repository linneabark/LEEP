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
import com.example.linneabark.test.SaveActivityRowList;

import edu.chl.leep.model.Leep;
import edu.chl.leep.model.LoginActivityModel;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivity extends AppCompatActivity { //TODO change name to LoginActivityCtrl

    private EditText userName;
    private EditText passWord;
    private TextView eM; //errorMessage
    private RadioButton rB; //keep the login
    private Context mContext;
    private static Leep leep;
    private LoginActivityModel loginActivityModel;
    private Button registerButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);

        //Måste kunna kommas åt i hela programmet, sätt public static
        getInstance();

        mContext = this;
        loginActivityModel = new LoginActivityModel();

        if(loginActivityModel.userWasLoggedIn(mContext)){
            Intent toy = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(toy);
        }

        registerButton = (Button) this.findViewById(R.id.registerButton);
        loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);
        eM = (TextView) this.findViewById(R.id.errormessage_login);

        System.out.println(Leep.getKeepLoginState(mContext));

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!loginActivityModel.compareUserInfo(mContext, userName, passWord)) {
                    eM.setText("Password or username does not match!");
                    SaveActivityRowList.putTheValuesInActivityRowList(mContext);

                } else {
                    loginActivityModel.rememberUser(mContext, rB);
                    Intent LoginToMain = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(LoginToMain);
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
    public static Leep getInstance(){
        if(leep == null){
            leep = new Leep();
        }
        return leep;
    }
}