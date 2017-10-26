package com.nlecloud.requestEntity;

public class LoginEntity {
    private String Account;
    private String Password;

    public LoginEntity(String account, String password) {
        Account = account;
        Password = password;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String  Account() {

        return Account;
    }

    public String  Password() {
        return Password;
    }
}
