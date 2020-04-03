package com.belhard.logintest;

import java.util.ArrayList;

public class UserBase {
     static ArrayList<UserAccount> users;

   // public static void AddUser(UserAccount user){users.add(user);}

    public static void AddUser(String name,String login,String password){
        UserAccount user=new UserAccount();
        
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        users.add(user);
    }

    public  UserBase(){ users=new ArrayList<UserAccount>();}

public  static boolean checkUser( String login, String password) {

    for (UserAccount u : users) {

        System.out.println("Проверяем присутствие пользователя "+login+" "+password);
        if (u.getLogin().equals(login) && u.getPassword().equals(password) ) {
            System.out.println("Пользователь найден");
            return true;
             }
    }
    return false;
}

    public  static boolean haveUser(String checkuser) {

        for (UserAccount u : users) {


            if (u.getLogin().equals(checkuser)  ) {

                return true;
            }
        }
        return false;
    }

    public static UserAccount getUser( String login, String password){
        for (UserAccount u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }

        }

        return null;
    }
   
   


}
