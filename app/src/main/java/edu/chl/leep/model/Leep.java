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
 */

public class Leep {

   // User actual
    // List<Activity>
    public Leep(){
        String userName;
        String password;

    }

    public static List<String> getCategoryList(Context mContext){
        List<String> categoryList = new ArrayList<>();

        categoryList.add(getCategory1(mContext));
        categoryList.add(getCategory2(mContext));
        categoryList.add(getCategory3(mContext));

        return categoryList;

    }

    // getActitivire

    //TODO metod: register(User)
    //TODO metod: login(User)

    //TODO getters

    public static void register(){
        System.out.println("Skriver den ut här?");
        Leep.setUSER(RegisterActivityController.newUser.user); //sets the "user folder with the same name as username"
        Leep.setUsername(User.mContext, RegisterActivityController.newUser.userName);
        Leep.setPassword(User.mContext, RegisterActivityController.newUser.password);
        Leep.setEmail(User.mContext, RegisterActivityController.newUser.email);

    }


    public static void setUSER(String input){
        User.theUser = input;
    }



    //all the getter
    public static String getUSER(){
        String y = User.theUser;
        return y;
    }

    //Fluttat från AccountDetails pga Hacht

    public static String getPreviousUser(Context context) {
        return FileService.getPrefPreviousUser(context).getString("user", "");
    }

    public static void setPreviousUser(Context context, String input){
        SharedPreferences.Editor editor = FileService.getPrefPreviousUser(context).edit();
        editor.putString("user", input);

        editor.apply();
    }

    //Flyttat från AccountDetails

    //HANDLE THE USER INFO

    private static SharedPreferences getUserInfos(Context context) { //or is it getPrefs?
        System.out.println("Context: " + context);
        return context.getSharedPreferences(getUSER(), Context.MODE_PRIVATE);
    }

    private static SharedPreferences getUserInfo(Context context) { //or is it getPrefs?
        return context.getSharedPreferences(User.USER_INFO, Context.MODE_PRIVATE);
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


