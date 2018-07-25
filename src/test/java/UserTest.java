import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {
    private UserList userList;
    @Before
    public void createUserList() {
        userList = new UserList();
    }
    @Test
    
    public void testCreateUser() throws UserAlreadyInTheBaseException, TooShortPasswordException, UserNotExistInBaseException {
        String login = "Michal123";
        String password = "haslo123";
        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.userRegister(login,password));

    }

}

