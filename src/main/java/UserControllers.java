import java.util.Map;

public class UserControllers {
    UserList userList = UserList.getInstance() ;

    public boolean createUser(String login, String password) throws IllegalArgumentException {
        userList.createUser(login,password);
        return true;
    }

    public boolean userIsPresent(String login, String password) {
        if(UserList.getInstance().getUserList().containsKey(login) && UserList.getInstance().getUserList().equals(password)) {
            return true;
        }
        else
        return false;
    }


}
