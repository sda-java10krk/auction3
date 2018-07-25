import Exceptions.TooShortPasswordException;
import Exceptions.UserNotExistInBaseException;

public class UserControllers {

//    public static User login(String login, String password) {
//
//    }

    public boolean userRegister (String login, String password) throws TooShortPasswordException, UserNotExistInBaseException {
        User user = new User (login,password);
        UserList.getInstance().findUser(login, password);
        return true;
    }




}


