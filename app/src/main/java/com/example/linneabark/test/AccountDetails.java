package com.example.linneabark.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Eli on 2017-05-10.
 */

public class AccountDetails {

    private SharedPreferences sharedPreferences;
    private static String USER_INFO = "UserInfo";

    public void AccountDetails() {
        // Blank
    }

    private static SharedPreferences getUserInfo(Context context) { //or is it getPrefs?
        return context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
    }

    public static String getUsername(Context context) {
        return getUserInfo(context).getString("Username", "");
    }

    public static String getPassword(Context context) {
        return getUserInfo(context).getString("Password", "");
    }
    public static String getEmail(Context context) {
        return getUserInfo(context).getString("Email", "");
    }


    //maybe change to be able to setUsername without having to define a EditText?
    //input.getText().toString(); in the other class and pass it as a string
    public static void setUsername(Context context, EditText input) {
        SharedPreferences.Editor editor = getUserInfo(context).edit();
        editor.putString("Username", input.getText().toString());

        editor.apply();

    }

    public static void setEmail(Context context, EditText input) {
        SharedPreferences.Editor editor = getUserInfo(context).edit();
        editor.putString("Email", input.getText().toString());

        editor.apply();

    }

    public static void setPassword(Context context, EditText input) {
        SharedPreferences.Editor editor = getUserInfo(context).edit();
        editor.putString("Password", input.getText().toString());

        editor.apply();

    }

    public static void setKeepLoginStateToZero(Context context, int x){
        SharedPreferences.Editor editor = getUserInfo(context).edit();

        editor.putInt("RadioButton", x);
        editor.apply();
    }

    public static void setKeepLoginState(Context context, RadioButton input) {


        SharedPreferences.Editor editor = getUserInfo(context).edit();

        boolean checked = input.isChecked();

        if (checked) {

            editor.putInt("RadioButton", 1);
        }else

        editor.putInt("RadioButton", 0);
        editor.apply();
    }

    public static int getKeepLoginState(Context context) {
        return getUserInfo(context).getInt("RadioButton", 0);
    }



}





