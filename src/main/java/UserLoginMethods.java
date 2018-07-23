
public class UserLoginMethods {

    public User registerUser(String login, String password){

        User user = new User();

        user.setLogin(login);
        user.setPassword(password);

        return user;
    }


}
