package Controllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserNotExistInBaseException;
import Models.User;
import java.util.Map;


public class UserControllers {

    UserList userList = UserList.getInstance();


    public boolean userRegister (String login, String password) throws TooShortPasswordException, UserNotExistInBaseException {
        User user = new User (login,password);
        UserList.getInstance().findUser(login, password);
        return true;
    }




}


