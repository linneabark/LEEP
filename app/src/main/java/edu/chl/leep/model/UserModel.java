package edu.chl.leep.model;

/**
 * Created by linneabark on 2017-05-22.
 * A class which describes what a user in the LEEP app is
 */

//Den här SKAPAR en användare, och från detta objekt kan vi HÄMTA info, men INTE SPARA/set:a
public class UserModel {

    // private String USER_INFO = "UserInfo";
    //private String theUser = "";
   // private String user;
    private String login; //TODO unique
    private String email;
    private String password;


    public UserModel(String login, String email, String password){
        //this.user = user;
        this.login = login;
        this.email = email;
        this.password = password;
    } //save object instead of loose strings

   /* public String getTheUser (){
        return user;
    }*/

   public String getLogin(){
       return login;
   }
   public String getEmail(){
       return email;
   }
   public String getPassword(){
       return password;
   }
}
