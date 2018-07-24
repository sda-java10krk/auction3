import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {

    @Test
    public void saveUserToListTest ()  {
        Map<String, User> userListTest = new HashMap<>();
        userListTest.put("login", new User("Login","Hasło"));

        //User userTest = new User ("login","haslo");

        FileManager fileManager = new FileManager();

        fileManager.saveUserToList(userListTest.keySet());

        User readUser = fileManager.readUserFromList();


        assertEquals(userTest, readUser);
    }
}
