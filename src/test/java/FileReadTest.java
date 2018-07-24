import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {

    @Test
    public void saveUserToListTest ()  {

        User userTest = new User ("login","haslo");


        FileManager fileManager = new FileManager();

        fileManager.saveUserToList(userTest);
        User readUser = fileManager.readUserFromList();

        assertEquals(userTest, readUser);
    }
}
