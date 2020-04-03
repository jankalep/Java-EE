package com.belhard.logintest;

import java.io.Serializable;

public class UserAccount {
   
    String name;
    String login;
    String password;
    

    public UserAccount(){
      
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
