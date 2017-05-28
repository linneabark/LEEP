package com.example.linneabark.test.unused;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.RadioButton;

public class AccountCheck {
    // RegisterActivityController registerActivity = new RegisterActivityController();
    private CreateAccount createAccount;

    private String password; // Ska bytas ut, finns endast så koden går att köra

    public boolean checkOldPassword(String oldPassword) {
        if (oldPassword.equals(createAccount.getPassword())) {
            return true;
        }
        return false;
    }

    // Kollar om lösenorden stämmer överens med varandra, i så fall returnaras true
    public boolean checkPassword(String password, String repeatedPassword) {
        if (password.equals(repeatedPassword)) {
            return true;
        }
        return false;
    }

    // Returnerar om mailen är ok, använder sig av fler metoder som kollar om det stämmer
    public boolean checkMail(String mail) {
        char[] eMail = mail.toCharArray();

        if (!eMailContainsOfAt(eMail)) {
            return false;
        }

        if (!eMailContainsOfDot(eMail)) {
            return false;
        }

        return true;
    }

    private int atPlace;

    // Kollar om mailet består av @ och om det är på "rätt" plats
    private boolean eMailContainsOfAt(char[] checkMail) {
        if (checkMail[0] == '@' || checkMail[checkMail.length - 1] == '@') {
            System.out.println("Checking for @ at place 1 and last");
            return false;
        }

        for (int i = 0; i < checkMail.length; i++) {
            if (checkMail[i] == '@') {
                atPlace = i;
                return true;
            }
        }

        return false;
    }

    // Kollar om mailet består av . och om det är på "rätt" plats
    private boolean eMailContainsOfDot(char[] eMail) {
        if (eMail[0] == '.' || eMail[eMail.length - 1] == '.') {
            return false;
        }

        for (int i = atPlace + 1; i < eMail.length; i++) {
            if (eMail[i] == '.') {
                return true;
            }
        }
        return false;
    }

    /**
     * Created by Eli on 2017-05-10.
     */

    public static class AccountDetails {

        private SharedPreferences sharedPreferences;

        // TODO till UserModel
        private static String USER_INFO = "UserInfo";

        static String theUser = "";
        static String category1 = "Category1";
        static String category2 = "Category2";
        static String category3 = "Category3";


        public void AccountDetails() {
            // Blank
        }

        public static void setUSER(String input){
            theUser = input;
        }



        //all the getter
        public static String getUSER(){
            String y = theUser;
            return y;
        }

        //HANDLE PREVIOUS USER

        private static SharedPreferences getPrefPreviousUser(Context context) { //or is it getPrefs?
            //TODO flytta till fileservice, allt som har med att skriva ut

            return context.getSharedPreferences("previousUser", Context.MODE_PRIVATE);
        }

        public static String getPreviousUser(Context context) {
            return getPrefPreviousUser(context).getString("user", "");
        }

        public static void setPreviousUser(Context context, String input){
            SharedPreferences.Editor editor = getPrefPreviousUser(context).edit();
            editor.putString("user", input);

            editor.apply();
        }

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



    }
}