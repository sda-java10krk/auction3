package Controllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import Models.User;
import java.util.Map;


public class UserControllers {


    UserList userList = UserList.getInstance();

    public boolean userLogin(String login, String password) throws TooShortPasswordException, UserNotExistInBaseException {

        User user = new User(login, password);
        if (UserList.getInstance().findUser(login, password)) {
            return true;
        }
        return false;
    }

    public boolean userRegister(String login, String password) throws UserAlreadyInTheBaseException, TooShortPasswordException {
        if (UserList.getInstance().registerUser(login, password)) {
            return true;
        }
        return false;
    }
}







