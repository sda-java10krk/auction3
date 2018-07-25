import Controllers.UserControllers;
import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

public class UserTest {
    private UserList userList;
    @Before
    public void createUserList() {
        userList = new UserList();
    }

    @Test
    public void testCreateUser() throws Exception {
        String login = "Michal123";
        String password = "haslo123";
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

}

