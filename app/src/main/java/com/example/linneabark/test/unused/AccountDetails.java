package com.example.linneabark.test.unused;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eli on 2017-05-10.
 */

public class AccountDetails {

    private SharedPreferences sharedPreferences;

    // TODO till User

    //Flyttat till User
    /*
    private static String USER_INFO = "UserInfo";

    static String theUser = "";
    static String category1 = "Category1";
    static String category2 = "Category2";
    static String category3 = "Category3";
*/

    public void AccountDetails() {
        // Blank
    }

    //Flyttat till Leep
    /*
    public static void setUSER(String input){
        theUser = input;
    }



    //all the getter
    public static String getUSER(){
        String y = theUser;
        return y;
    }
    */

    //HANDLE PREVIOUS USER


    //Flyttat till fileservice
    /*
    private static SharedPreferences getPrefPreviousUser(Context context) { //or is it getPrefs?
        //TODO flytta till fileservice, allt som har med att skriva ut

        return context.getSharedPreferences("previousUser", Context.MODE_PRIVATE);
    }*/

    //Flyttat till Leep
    /*
    public static String getPreviousUser(Context context) {
        return getPrefPreviousUser(context).getString("user", "");
    }

    public static void setPreviousUser(Context context, String input){
        SharedPreferences.Editor editor = getPrefPreviousUser(context).edit();
        editor.putString("user", input);

        editor.apply();
    }*/

    //Flyttat till LEEP

    /*
    //HANDLE THE USER INFO

    private static SharedPreferences getUserInfos(Context context) { //or is it getPrefs?
        return context.getSharedPreferences(getUSER(), Context.MODE_PRIVATE);
    }

    private static SharedPreferences getUserInfo(Context context) { //or is it getPrefs?
        return context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
    }

    //gets the specific key and value in it

    public static String getUsername(Context context) {
        return getUserInfos(context).getString("Username", "");
    }

    public static String getPassword(Context context) {
        return getUserInfos(context).getString("Password", "");
    }
    public static String getEmail(Context context) {
        return getUserInfos(context).getString("Email", "");
    }

    //the categories

    public static String getCategory(Context context, int x) {
        return getUserInfos(context).getString("Category "+x, "");
    }

    public static String getCategory1(Context context) {
        return getUserInfos(context).getString("Category 1", "");
    }

    public static String getCategory2(Context context) {
        return getUserInfos(context).getString("Category 2", "");
    }

    public static String getCategory3(Context context) {
        return getUserInfos(context).getString("Category 3", "");
    }

    public static void setCategory(Context context, String input, int x){
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Category " + x, input);

        editor.apply();
    }


    public static void setCategory1(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Category 1", input);

        editor.apply();

    }



    public static void setCategory2(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Category 2", input);

        editor.apply();

    }


    public static void setCategory3(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Category 3", input);

        editor.apply();

    }


    //maybe change to be able to setUsername without having to define a EditText?
    //input.getText().toString(); in the other class and pass it as a string

    //all the setters
    public static void setUsername(Context context, EditText input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Username", input.getText().toString());

        editor.apply();

    }

    public static void setEmail(Context context, EditText input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Email", input.getText().toString());

        editor.apply();

    }

    public static void setPassword(Context context, EditText input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Password", input.getText().toString());

        editor.apply();

    }




    //keeps track of wether or not the user is already logged in or not

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


*/
}




