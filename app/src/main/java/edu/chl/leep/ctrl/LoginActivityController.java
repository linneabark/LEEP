package edu.chl.leep.ctrl;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linneabark.test.R;

import edu.chl.leep.model.LeepModel;
import edu.chl.leep.model.UserModel;
import edu.chl.leep.service.FileService;
import edu.chl.leep.service.LoginService;
import edu.chl.leep.service.SaveActivityService;
import edu.chl.leep.service.UserStateService;
import edu.chl.leep.utils.Contexts;
import edu.chl.leep.utils.Intents;

/**
 * Created by Eli on 2017-05-08.
 */

public class LoginActivityController extends AppCompatActivity {
    private EditText userName;
    private EditText passWord;
    private TextView eM; //errorMessage
    private RadioButton rB; //keep the login
    private Context mContext;
    private static LeepModel leep;
    private UserStateService uis;
    private LoginService loginService;
    private FileService fileService;
    private Button registerButton;
    private Button loginButton;

    private String SPUserName;
    private String SPPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);
        getInstance();

        mContext = this;
        Contexts.setContexts(mContext);

        uis = new UserStateService();
        fileService = new FileService();
        loginService = new LoginService();

        if(LeepModel.getUSER() == null) {
            LeepModel.register(new UserModel("","",""));
        }

        if(uis.userWasLoggedIn()){
            getSavedActivitys();

            startActivity(Intents.ToMain(mContext));
        }

        registerButton = (Button) this.findViewById(R.id.registerButton);
        loginButton = (Button) this.findViewById(R.id.loginButton);
        userName = (EditText) this.findViewById(R.id.userName);
        passWord = (EditText) this.findViewById(R.id.password);
        rB = (RadioButton) this.findViewById(R.id.radioButton);
        eM = (TextView) this.findViewById(R.id.errormessage_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SPUserName = LeepModel.getUsername();
                SPPassword = LeepModel.getPassword();

                LeepModel.checkUser(userName.getText().toString());
                if (!loginService.compareUserInfo(userName.getText().toString(), passWord.getText().toString(), SPUserName, SPPassword)) {
                    eM.setText("Password or username does not match!");
                } else {

                    boolean checked = rB.isChecked();
                    uis.rememberUser(checked);

                    Toast.makeText(mContext, ("Logged in " + LeepModel.getUsername() + "!"), Toast.LENGTH_SHORT).show();
                    getSavedActivitys();

                    //Intent LoginToMain = new Intent(LoginActivityController.this, MainActivityController.class);
                    //startActivity(LoginToMain);

                    startActivity(Intents.ToMain(mContext));
                    // or
                    //startActivityForResult(intent, 1024);

                }

            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Intents.ToRegister(mContext));

            }



    });
        }
    public static LeepModel getInstance(){
        if(leep == null){
            leep = new LeepModel();
        }
        return leep;
    }

    private void getSavedActivitys(){
        //rensa lista om det fanns något innan man loggade ut.
        SaveActivityService.activityRowList.clear();
        //load the list from SharedPrefs.
        fileService.putTheValuesInActivityRowList(Contexts.getContexts());
    }
}