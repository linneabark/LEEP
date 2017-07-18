package edu.chl.leep.model;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.service.FileService;
import edu.chl.leep.utils.Contexts;

/**
 * Created by linneabark on 2017-05-22.
 *
 * Class that holds information about the users
 */

public class LeepModel {

    public LeepModel(){
    }

    public static List<String> getCategoryList(){
        List<String> categoryList = new ArrayList<>();

        categoryList.add(getCategory1());
        categoryList.add(getCategory2());
        categoryList.add(getCategory3());

        return categoryList;
    }

    public static void register(){
        LeepModel.setUSER(UserModel.user); //sets the "user folder with the same name as username"
        LeepModel.setUsername(UserModel.userName);
        LeepModel.setPassword(UserModel.password);
        LeepModel.setEmail(UserModel.email);
    }

    public static void setUSER(String input){
        UserModel.theUser = input;
    }

    public static String getUSER(){
        return UserModel.theUser;
    }

    public static String getPreviousUser() {
        return FileService.getPrefPreviousUser(Contexts.getContexts()).getString("user", "");
    }

    public static void setPreviousUser(String input){
        SharedPreferences.Editor editor = FileService.getPrefPreviousUser(Contexts.getContexts()).edit();
        editor.putString("user", input);

        editor.apply();
    }

    //HANDLE THE USER INFO
    private static SharedPreferences getUserInfos() { //or is it getPrefs?
        return Contexts.getContexts().getSharedPreferences(getUSER(), Contexts.getContexts().MODE_PRIVATE);
    }

    private static SharedPreferences getUserInfo() { //or is it getPrefs?
        return Contexts.getContexts().getSharedPreferences(UserModel.USER_INFO, Contexts.getContexts().MODE_PRIVATE);
    }

    public static String getUsername() {
        return getUserInfos().getString("Username", "");
    }

    public static String getPassword() {
        return getUserInfos().getString("Password", "");
    }
    public static String getEmail() {
        return getUserInfos().getString("Email", "");
    }

    public static String getCategory( int x) {
        return getUserInfos().getString("Category "+x, "");
    }

    public static String getCategory1() {
        return getUserInfos().getString("Category 1", "");
    }

    public static String getCategory2() {
        return getUserInfos().getString("Category 2", "");
    }

    public static String getCategory3() {
        return getUserInfos().getString("Category 3", "");
    }

    //the quotes
    public static String getQuote1() {
        return getUserInfos().getString("Quote 1", "");
    }

    public static String getQuote2(){
        return getUserInfos().getString("Quote 2", "");
    }

    public static String getQuote3 (){
        return  getUserInfos().getString("Quote 3", "");
    }

    public static void setQuote1(String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Quote 1", input);

        editor.apply();
    }

    public static void setQuote2(String input){
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Quote 2", input);

        editor.apply();
    }

    public static void setQuote3(String input){
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Quote 3", input);

        editor.apply();
    }

    public static void setCategory1( String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Category 1", input);

        editor.apply();
    }

    public static void setCategory2(String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Category 2", input);

        editor.apply();
    }

    public static void setCategory3( String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Category 3", input);

        editor.apply();
    }

    private static void setUsername(String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Username", input);

        editor.apply();
    }

    private static void setEmail(String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Email", input);

        editor.apply();
    }

    private static void setPassword(String input) {
        SharedPreferences.Editor editor = getUserInfos().edit();
        editor.putString("Password", input);

        editor.apply();
    }

    //keeps track of wether or not the user is already logged in or not
    public static void setKeepLoginStateToZero(int x){
        SharedPreferences.Editor editor = getUserInfo().edit();

        editor.putInt("RadioButton", x);
        editor.apply();
    }

    public static void setKeepLoginState(boolean input) {

        SharedPreferences.Editor editor = getUserInfo().edit();
        if (input) {
            editor.putBoolean("RadioButton", true);
        }else
            editor.putBoolean("RadioButton", false);
        editor.apply();
    }

    public static int getKeepLoginState() {
        return getUserInfo().getInt("RadioButton", 0);
    }
}


