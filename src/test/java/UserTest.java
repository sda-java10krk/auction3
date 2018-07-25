import Controllers.UserControllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import Models.User;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

public class UserTest {
    private UserList userList;
    @Before
    public void createUserList() throws Exception {
        userList = new UserList();

        userList.registerUser("Filip123","Haslo123");
        userList.registerUser("BartekKrul","Password");
        userList.registerUser("Marcin42","Pass3213");

    }

    @Test
    public void testLoginUser() throws Exception {

        String login = "Filip123";
        String password = "Haslo123";
        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.userLogin(login,password));
    }

    @Test(expected = TooShortPasswordException.class)
    public void testThrowTooShortExceptionIfPasswordIsTooShort() throws Exception {
        String login = "Michal123";
        String password = "h3";
        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.userLogin(login,password));

    }

    @Test(expected = UserAlreadyInTheBaseException.class)
    public void testThrowUserAlreadyInTheBaseException() throws Exception {
        String login = "Filip123";
        String password = "asdafasf";

        assert(userList.registerUser(login,password));
    }

}

