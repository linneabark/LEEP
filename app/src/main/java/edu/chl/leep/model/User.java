package edu.chl.leep.model;

import android.content.Context;

/**
 * Created by linneabark on 2017-05-22.
 */

public class User {

    public static String USER_INFO = "UserInfo";


    static String theUser = "";
    static String category1 = "Category1";
    static String category2 = "Category2";
    static String category3 = "Category3";
    static String user;
    static String userName;
    static String email;
    static String password;
    static Context mContext;


    public User(String user, String userName, String email, String password, Context mContext){

        this.user = user;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.mContext = mContext;

        /*
        Leep.setUSER(user); //sets the "user folder with the same name as username"
        Leep.setUsername(mContext, userName);
        Leep.setPassword(mContext, password);
        Leep.setEmail(mContext, email);

*/
    }


    //TODO ska innehålla namn, password, email m.m
}
