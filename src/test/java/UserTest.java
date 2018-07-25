import Exceptions.TooShortPassword;
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
    public void testCreateUser() {
        String login = "Michal123";
        String password = "haslo123";
            userList.createUser(login, password);

        assertTrue(userList.getUserList().containsKey(login));
    }

    @Test
    public void testUserLogin() throws TooShortPassword {
//        UserList userList = new UserList();
        userList.createUser("Konrad","Ityle123");
        userList.createUser("Michal","Haselko123");
        userList.createUser("Bogdan","Password123");


        String login = "Konrad";
        String password = "Ityle123";


    userList.findUser(login,password);

assertTrue(userList.findUser(login,password).equals(userList.getUserList()));

    }

}

