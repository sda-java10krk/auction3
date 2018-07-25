package Models;
import Exceptions.TooShortPasswordException;


import java.io.Serializable;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class User implements Serializable {


    public String login;
    public String password;


    public User(String login, String password) throws TooShortPasswordException {
        this.login = login;
        if(password.length()<5){
            throw new TooShortPasswordException();
        }
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) throws TooShortPasswordException {
            this.password = password;
        }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(login, password);
    }
}



