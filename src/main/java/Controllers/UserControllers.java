package Controllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import Models.User;
import java.util.Map;


public class UserControllers {

    public User userLogin (String login, String password) throws TooShortPasswordException, UserNotExistInBaseException {
        return UserList.getInstance().findUser(login, password);

    }

    public boolean userRegister(String login, String password) throws UserAlreadyInTheBaseException, TooShortPasswordException {
        if (UserList.getInstance().registerUser(login, password)) {
            return true;
        }
        return false;
    }
}







