package com.example.linneabark.test;

public class AccountCheck {
    // RegisterActivity registerActivity = new RegisterActivity();
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
}