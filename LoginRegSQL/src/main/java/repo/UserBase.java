package repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserBase {
   static String jdbcUrl="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
   static String jdbcUser="root";
   static String jdbcPassword="password";

    public static void AddUser(String name, String Login, String Password, boolean Admin) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){
                String sql = "INSERT INTO mydb.users (username, login, password, admin) values (?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, Login);
                    preparedStatement.setString(3, Password);
                    preparedStatement.setBoolean(4, Admin);
preparedStatement.execute();
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static boolean checkUser(String login, String password) {
        boolean check=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql = "SELECT * FROM users WHERE login=? and password=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        check=true;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally {
            return check;
        }
    }

    public static boolean haveUser(String checkuser) {
        boolean check=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql = "SELECT * FROM users WHERE login=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, checkuser);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        check=true;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally {
            return check;
        }
    }

    public static UserAccount getUser(String login, String password) {
        UserAccount user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql = "SELECT * FROM users WHERE login=? and password=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int Id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        boolean admin = resultSet.getBoolean(5);
                        user = new UserAccount();
                        user.setRole(admin);
                        user.setName(name);
                        user.setLogin(login);
                        user.setPassword(password);
                        user.setId(Id);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }

    public static void deleteUser(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){
                String sql = "DELETE FROM users WHERE id =?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    preparedStatement.execute();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static List<UserAccount> getAllUsers() {
        ArrayList<UserAccount> users = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("username");
                    String login=resultSet.getString("login");
                    String password=resultSet.getString("password");
                    boolean admin=resultSet.getBoolean("admin");
                    UserAccount user = new UserAccount();
                    user.setId(id);
                    user.setName(name);
                    user.setPassword(password);
                    user.setLogin(login);
                    user.setRole(admin);
                    users.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }
}
