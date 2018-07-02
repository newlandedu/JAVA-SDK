package com.nlecloud.sdk.requestEntity;

/**
 * Created by marco on 2017/8/21.
 * 登陆实体
 */

public class SignInEntity {
    private String Account;
    private String Password;

    public SignInEntity(String account, String password) {
        Account = account;
        Password = password;
    }
}
