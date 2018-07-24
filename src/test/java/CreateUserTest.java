import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateUserTest {
    private UserList userList;

    @Test
    public void testCreateUser() {
        userList = new UserList();
        String login = "Michal123";
        String password = "haslo123";

        userList.createUser(login, password);
        assertTrue(userList.getUserList().containsKey(login));
    }

}

