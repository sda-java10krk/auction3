import Controllers.UserControllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import Models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {
    private UserList userList;

    @Before
    public void createUserList() throws Exception {
        userList = new UserList();

        userList.registerUser("Filip123", "Haslo123");
        userList.registerUser("BartekKrul", "Password");
        userList.registerUser("Marcin42", "Pass3213");

    }

    @Test
    public void testLoginUser() throws Exception {
        UserControllers userControllers = new UserControllers();
        String login = "Filip123";
        String password = "Haslo123";

        assertTrue(userList.findUser(login,password).equals(userList));
    }

//    @Test(expected = UserNotExistInBaseException.class)
//    public void testThrowUserNotExist() throws Exception {
//        String login = "Fasdasd1";
//        String password = "dsadasdasd";
//        UserControllers userControllers = new UserControllers();
//        assertTrue(userControllers.userLogin(login, password));
//    }

    @Test(expected = TooShortPasswordException.class)
    public void testThrowTooShortExceptionIfPasswordIsTooShort() throws Exception {
        UserControllers userControllers = new UserControllers();
        String login = "Filip123";
        String password = "h3";
        User user = new User(login, password);
        assertTrue(user.getPassword().length() > 5);
    }

    @Test(expected = UserAlreadyInTheBaseException.class)
    public void testThrowUserAlreadyInTheBaseException() throws Exception {
        String login = "Filip123";
        String password = "asdafasf";

        assert (userList.registerUser(login, password));
    }

    @Test
    public void testAddUserToUserList() throws Exception {
        int result = userList.getInstance().getUserList().size();
        userList.registerUser("Filip_R", "Hassslo123");
        assertTrue(userList.getUserList().size() > result);
    }



}

