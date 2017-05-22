package com.example.linneabark.test.unused;

import java.util.ArrayList;
import java.util.List;

public class CreateAccount {
    private List<CreateAccount> accoutList = new ArrayList<>();
    // AccountController accountController = new AccountController();

    private String userName;
    private String mail;
    private String password;

    public CreateAccount() {
        // Behöver ha en tom konstruktor
    }

    public CreateAccount(String userName, String mail, String password) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
    }

    public void addAccount(CreateAccount createAccount) {
        accoutList.add(createAccount);
    }

    public String getUserName() {
        return userName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMail(String newMail) {
        this.mail = newMail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}