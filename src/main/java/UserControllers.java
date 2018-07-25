import Exceptions.TooShortPassword;

import java.io.IOException;
import java.util.Map;

public class UserControllers {

    public static User login(String login, String password) {
        User user = UserList.getInstance().findUser(login,password);
        return user;
    }

    public boolean createUser(String login, String password) throws TooShortPassword {
        UserList.getInstance().createUser(login, password);
        return true;
    }




}


