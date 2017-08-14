package edu.chl.leep.model;

/**
 * Created by linneabark on 2017-05-22.
 * A class which describes what a user in the LEEP app is
 */

public class UserModel {

    public static String USER_INFO = "UserInfo";
    static String theUser = "";
    static String user;
    static String userName;
    static String email;
    static String password;


    public UserModel(String user, String userName, String email, String password){
        this.user = user;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
