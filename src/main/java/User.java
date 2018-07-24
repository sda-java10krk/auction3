import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

    public String login;
    public String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    }



