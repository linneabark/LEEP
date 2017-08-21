package edu.chl.leep.model;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.service.FileService;
import edu.chl.leep.utils.Contexts;

/**
 * Created by linneabark on 2017-05-22.
 *
 * Class that holds information about the users
 */

public class LeepModel {

    private static UserModel user;
    public static String checkUserName;

    public LeepModel(){

    }

    public static List<String> getCategoryList(){
        List<String> categoryList = new ArrayList<>();

        categoryList.add(getCategory1());
        categoryList.add(getCategory2());
        categoryList.add(getCategory3());

        return categoryList;
    }


    public static void register (UserModel newUser) {
        setUser(newUser);
        setUSER(newUser); //sets the "user folder with the same name as username"
        setSPUsername(newUser);
        setSPPassword(newUser);
        setSPEmail(newUser);
    }





    public static UserModel getUSER(){
        return user;
    }

    public static void checkUser (String input) {
        checkUserName = input;
    }

    public static String getPreviousUser() {
        return getPrefPreviousUser().getString("user", "");
    }

     public static SharedPreferences getPrefPreviousUser() {
            return Contexts.getContexts().getSharedPreferences("previousUser", Contexts.getContexts().MODE_PRIVATE);
        }

    public static void setPreviousUser(){
        SharedPreferences.Editor editor = getPrefPreviousUser().edit();
        editor.putString("user", checkUserName);

        editor.apply();
    }

    public static void setUser (UserModel input){
        checkUserName = input.getLogin();

    }

    //HANDLE THE USER INFO
    private static SharedPreferences getUserInfo() { //or is it getPrefs?
        return Contexts.getContexts().getSharedPreferences(checkUserName, Contexts.getContexts().MODE_PRIVATE);
    }


    public static String getUsername() {
        return getUserInfo().getString("Username", "");
    }

    public static String getPassword() {
        return getUserInfo().getString("Password", "");
    }
    public static String getEmail() {
        return getUserInfo().getString("Email", "");
    }

    public static String getCategory(int x) {
        return getUserInfo().getString("Category "+x, "");
    }

    public static String getCategory1() {
        return getUserInfo().getString("Category 1", "");
    }

    public static String getCategory2() {
        return getUserInfo().getString("Category 2", "");
    }

    public static String getCategory3() {
        return getUserInfo().getString("Category 3", "");
    }

    //the quotes
    public static String getQuote1() {
        return getUserInfo().getString("Quote 1", "");
    }

    public static String getQuote2(){
        return getUserInfo().getString("Quote 2", "");
    }

    public static String getQuote3(){
        return getUserInfo().getString("Quote 3", "");
    }


    /*public static String setUSER(UserModel user){
        return user.getLogin();
    }   */

    public static void setUSER (UserModel input) {
          user = input;
    }


    public static void setQuote1(String input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Quote 1", input);

        editor.apply();
    }

    public static void setQuote2(String input){
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Quote 2", input);

        editor.apply();
    }

    public static void setQuote3(String input){
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Quote 3", input);

        editor.apply();
    }

    public static void setCategory1( String input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Category 1", input);

        editor.apply();
    }

    public static void setCategory2(String input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Category 2", input);

        editor.apply();
    }

    public static void setCategory3( String input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Category 3", input);

        editor.apply();
    }

    private static void setSPUsername(UserModel input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Username", input.getLogin());

        editor.apply();
    }

    private static void setSPEmail(UserModel input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Email", input.getEmail());

        editor.apply();
    }

    private static void setSPPassword(UserModel input) {
        SharedPreferences.Editor editor = getUserInfo().edit();
        editor.putString("Password", input.getPassword());

        editor.apply();
    }



    //---------

    private static SharedPreferences getKeepLoggedIn() { //or is it getPrefs?
        return Contexts.getContexts().getSharedPreferences("LoggedInState", Contexts.getContexts().MODE_PRIVATE);
    }


    //keeps track of wether or not the user is already logged in or not
    public static void setKeepLoginStateToFalse(){
        SharedPreferences.Editor editor = getKeepLoggedIn().edit();

        editor.putInt("RadioButton", 1);
        editor.apply();
    }

    public static void setKeepLoginState(boolean input) {

        SharedPreferences.Editor editor = getKeepLoggedIn().edit();
        if (input) {
            editor.putInt("RadioButton", 0);
            editor.apply();
        }if(!input) {
            editor.putInt("RadioButton", 1);
            editor.apply();
        }
    }

    public static int getKeepLoginState() {
        return getKeepLoggedIn().getInt("RadioButton", 0);
    }


}


