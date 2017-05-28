package edu.chl.leep.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.ctrl.RegisterActivityController;
import edu.chl.leep.service.FileService;

/**
 * Created by linneabark on 2017-05-22.
 *
 * Class that holds information about the users
 */

public class LeepModel {

    public LeepModel(){
    }

    public static List<String> getCategoryList(Context mContext){
        List<String> categoryList = new ArrayList<>();

        categoryList.add(getCategory1(mContext));
        categoryList.add(getCategory2(mContext));
        categoryList.add(getCategory3(mContext));

        return categoryList;
    }

    public static void register(){
        LeepModel.setUSER(UserModel.user); //sets the "user folder with the same name as username"
        LeepModel.setUsername(UserModel.mContext, UserModel.userName);
        LeepModel.setPassword(UserModel.mContext, UserModel.password);
        LeepModel.setEmail(UserModel.mContext, UserModel.email);
    }

    public static void setUSER(String input){
        UserModel.theUser = input;
    }

    public static String getUSER(){
        return UserModel.theUser;
    }

    public static String getPreviousUser(Context context) {
        return FileService.getPrefPreviousUser(context).getString("user", "");
    }

    public static void setPreviousUser(Context context, String input){
        SharedPreferences.Editor editor = FileService.getPrefPreviousUser(context).edit();
        editor.putString("user", input);

        editor.apply();
    }

    //HANDLE THE USER INFO
    private static SharedPreferences getUserInfos(Context context) { //or is it getPrefs?
        System.out.println("Context: " + context);
        return context.getSharedPreferences(getUSER(), Context.MODE_PRIVATE);
    }

    private static SharedPreferences getUserInfo(Context context) { //or is it getPrefs?
        return context.getSharedPreferences(UserModel.USER_INFO, Context.MODE_PRIVATE);
    }

    public static String getUsername(Context context) {
        return getUserInfos(context).getString("Username", "");
    }

    public static String getPassword(Context context) {
        return getUserInfos(context).getString("Password", "");
    }
    public static String getEmail(Context context) {
        return getUserInfos(context).getString("Email", "");
    }

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

    //the quotes
    public static String getQuote1(Context context) {
        return getUserInfos(context).getString("Quote 1", "");
    }

    public static String getQuote2(Context context){
        return getUserInfos(context).getString("Quote 2", "");
    }

    public static String getQuote3 (Context context){
        return  getUserInfos(context).getString("Quote 3", "");
    }

    public static void setQuote1(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Quote 1", input);

        editor.apply();
    }

    public static void setQuote2(Context context, String input){
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Quote 2", input);

        editor.apply();
    }

    public static void setQuote3(Context context, String input){
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Quote 3", input);

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

    private static void setUsername(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Username", input);

        editor.apply();
    }

    private static void setEmail(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Email", input);

        editor.apply();
    }

    private static void setPassword(Context context, String input) {
        SharedPreferences.Editor editor = getUserInfos(context).edit();
        editor.putString("Password", input);

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


