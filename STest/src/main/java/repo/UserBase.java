package repo;

import java.util.ArrayList;
import java.util.List;

public class UserBase {
    static List<UserAccount> users;

    public static void AddUser(String name, String login, String password, boolean admin) {
        UserAccount user = new UserAccount();
        user.setRole(admin);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        users.add(user);
    }

    public UserBase() {
        users = new ArrayList<>();
    }

    public static boolean checkUser(String login, String password) {
        for (UserAccount u : users) {
            System.out.println("Проверяем присутствие пользователя " + login + " " + password);
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                System.out.println("Пользователь найден");
                return true;
            }
        }
        return false;
    }

    public static boolean haveUser(String checkuser) {
        for (UserAccount u : users) {
            if (u.getLogin().equals(checkuser)) {
                return true;
            }
        }
        return false;
    }

    public static UserAccount getUser(String login, String password) {
        for (UserAccount u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public static void deleteUser(int id) {
        for (UserAccount u : users) {
            if (u.getId() == id) {
                users.remove(u);
                break;
            }
        }
    }

    public static List<UserAccount> getAllUsers() {
        return users;
    }
}
