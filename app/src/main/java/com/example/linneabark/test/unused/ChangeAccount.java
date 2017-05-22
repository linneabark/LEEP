package com.example.linneabark.test.unused;

public class ChangeAccount {
    AccountCheck accountCheck = new AccountCheck();
    private CreateAccount createAccount;

    private void changeUserName(String newName) {
        // setUserName(newName);
        createAccount.setUserName(newName);
    }

    private void changeMail(String mail) {
        mail = "A string for now";
        boolean mailChecked = accountCheck.checkMail(mail);

        if (mailChecked) {
            // setMail(mail);
            createAccount.setMail(mail);
        }
        else {
            // Ett felmeddelande?!
        }
    }

    private void changePassword(String oldPassword, String newPassword, String newRepeatedPassword) {
        boolean oldPasswordChecked = accountCheck.checkOldPassword(oldPassword);
        boolean newPasswordChecked = accountCheck.checkPassword(newPassword, newRepeatedPassword);

        if (oldPasswordChecked && newPasswordChecked) {
            createAccount.setPassword(newPassword);
        }
        else {
            // Ett felmeddelande?!
        }
    }
}