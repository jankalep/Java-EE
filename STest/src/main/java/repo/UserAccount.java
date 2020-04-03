package repo;

public class UserAccount {
   static int size=0;
   int id;
    String name;
    String login;
    String password;
    boolean role;

    public UserAccount(){
       id=size;
       size++;
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

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

}
