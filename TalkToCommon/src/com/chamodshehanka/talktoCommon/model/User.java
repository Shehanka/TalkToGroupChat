package com.chamodshehanka.talktoCommon.model;

import java.io.Serializable;

/**
 * @author chamodshehanka on 11/17/2017
 * @project TalkTo
 **/
public class User implements Serializable{
    private String userName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
