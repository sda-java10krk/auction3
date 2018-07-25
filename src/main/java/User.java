import Exceptions.TooShortPasswordException;

public class User {

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

}



