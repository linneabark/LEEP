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

import com.example.linneabark.test.R;

import edu.chl.leep.model.LeepModel;
import edu.chl.leep.model.LoginActivityModel;
import edu.chl.leep.service.FileService;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivityController extends AppCompatActivity { //TODO change name to LoginActivityCtrl

    private EditText userName;
    private EditText passWord;
    private TextView eM; //errorMessage
    private RadioButton rB; //keep the login
    private Context mContext;
    private static LeepModel leep;
    private LoginActivityModel loginActivityModel;
    private FileService fileService;
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
        fileService = new FileService();

        if(loginActivityModel.userWasLoggedIn(mContext)){
            Intent toy = new Intent(LoginActivityController.this, MainActivityController.class);
            startActivity(toy);
        }

        registerButton = (Button) this.findViewById(R.id.registerButton);
        loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);
        eM = (TextView) this.findViewById(R.id.errormessage_login);

        System.out.println(LeepModel.getKeepLoginState(mContext));

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!loginActivityModel.compareUserInfo(mContext, userName, passWord)) {
                    eM.setText("Password or username does not match!");
                } else {
                    fileService.putTheValuesInActivityRowList(mContext);
                    loginActivityModel.rememberUser(mContext, rB);
                    Intent LoginToMain = new Intent(LoginActivityController.this, MainActivityController.class);
                    startActivity(LoginToMain);
                }
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(LoginActivityController.this, RegisterActivityController.class);
                startActivity(toy);
            }



    });
        }
    public static LeepModel getInstance(){
        if(leep == null){
            leep = new LeepModel();
        }
        return leep;
    }
}