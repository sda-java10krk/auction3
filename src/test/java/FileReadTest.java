
import Exceptions.TooShortPasswordException;
import Models.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {

    public static final String FILE_NAME = "Controllers.UserList.txt";

    @Test
    public void saveUserToListTest () throws IOException, TooShortPasswordException {

        User userTest = new User ("login","haslo1");


        FileManager fileManager = new FileManager();
        fileManager.saveUserToList(userTest);

        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);


      //  assertEquals(u);

    }
}
