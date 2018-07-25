import Exceptions.TooShortPassword;

import java.io.IOException;
import java.util.Map;

public class UserControllers {

    public static User login(String login, String password) {
        User user = UserList.getInstance().login(user);
        return user;
    }

    public boolean userRegister (String login, String password) throws TooShortPassword {
        User user = new User (login,password);
        UserList.getInstance().createUser(login, password);
        return true;
    }




}


