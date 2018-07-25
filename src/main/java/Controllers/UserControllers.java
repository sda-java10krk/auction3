package Controllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserNotExistInBaseException;
import Models.User;
import java.util.Map;


public class UserControllers {

    public boolean userLogin (String login, String password) throws TooShortPasswordException, UserNotExistInBaseException {
        User user = new User (login,password);
        UserList.getInstance().findUser(login, password);
        return true;
    }




}


