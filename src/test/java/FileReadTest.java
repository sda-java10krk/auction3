import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {

    public static final String FILE_NAME = "UserList.txt";

    @Test
    public void saveUserToListTest () throws IOException {

        User userTest = new User ();
        userTest.createUser("Login","Hasło");

        FileManager fileManager = new FileManager();
        fileManager.saveUserToList(userTest);

        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);


      //  assertEquals(u);

    }
}
