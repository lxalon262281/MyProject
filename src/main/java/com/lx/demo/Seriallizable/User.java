package com.lx.demo.Seriallizable;

import java.io.Serializable;

public class User implements Serializable {
    public User(String string, String string2, String string3) {
        // TODO Auto-generated constructor stub
    }

    private String userName;
    private String password;
    private String sex;

    public String getUserName(String userName) {
        return userName;
    }

    public String getPassword(String password) {
        return password;
    }

    public String getSex(String sex) {
        return sex;
    }
}