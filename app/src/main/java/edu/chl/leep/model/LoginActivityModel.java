package edu.chl.leep.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import edu.chl.leep.ctrl.LoginActivity;
import edu.chl.leep.ctrl.MainActivity;
import edu.chl.leep.service.AccountDetails;

/**
 * Created by Eli on 2017-05-23.
 */

public class LoginActivityModel {

    public boolean compareUserInfo(Context mContext, EditText userName, EditText passWord) {

        AccountDetails.setUSER(userName.getText().toString());

        if ((AccountDetails.getUSER().equals(AccountDetails.getUsername(mContext))) && (passWord.getText().toString().equals(AccountDetails.getPassword(mContext)))) {
            return true;
        }

        return false;

    }

    public boolean userWasLoggedIn(Context mContext) {

        if (AccountDetails.getKeepLoginState(mContext) == 1) {

            AccountDetails.setUSER(AccountDetails.getPreviousUser(mContext));

            return true;

        }

        return false;

    }


    public void setUserSettings(Context mContext, RadioButton rB) {

        AccountDetails.setKeepLoginState(mContext, rB);//see whether or not the radiobutton is checked(1 = true, 0 = false)
        AccountDetails.setPreviousUser(mContext, AccountDetails.getUSER());

        Toast.makeText(mContext, ("Logged in " + AccountDetails.getUsername(mContext) + "!"), Toast.LENGTH_SHORT).show();

    }

}