import Exceptions.EmptyDescriptionException;
import Exceptions.EmptyTitleException;
import Exceptions.SubcategoryPresentException;
import Exceptions.TooLowPriceException;
import Models.Auction;
import Models.Category;
import Models.Offers;
import Models.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {


    public static final String FILE_NAME = "Controllers.UserList.txt";

    @Test
    public void saveUserToListTestAndChechResultByMethodReadFile ()  {
        Map<String, User> userListTest = new HashMap<>();

        userListTest.put("login", new User("Login","Hasło"));

        FileManager fileManager = new FileManager();
        fileManager.saveUserToList(userListTest);

        HashMap <String,User> readUser = fileManager.readUserFromList();
        assertEquals(userListTest, readUser);
    }

    @Test
    public void saveAuctionAndOffersAndChechResultByMethodReadFile () throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {

        Map<Auction, List<Offers>> userListTest2 = new HashMap<>();
        userListTest2.put(new Auction(new User ("login","password"),"password","description",BigDecimal.valueOf(100),new Category("category")),new ArrayList());


        List <Offers> offers = new ArrayList<>();
        offers.add(new Offers(

       userListTest2.put("Opel",new ArrayList());


        FileManager fileManager = new FileManager();
        fileManager.saveUserToList(userListTest2);


        HashMap <String,User> readUser = fileManager.readUserFromList();
        assertEquals(userListTest, readUser);
    }
}
