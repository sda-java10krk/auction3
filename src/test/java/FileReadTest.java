import Controllers.UserList;
import Exceptions.*;
import Helpers.AuctionFileManager;
import Helpers.UserFileManager;

import Models.Auction;
import Models.Category;
import Models.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {


    Map<String, User> saveUserListTest;

    @Before
    public void setup1() {
        saveUserListTest = new HashMap<>();
    }


    Map<String, User> saveAuctionToMapTest;

    @Before
    public void setup2() {
        saveAuctionToMapTest = new HashMap<>();
    }

    @Test
    public void saveUserToListAndChechResultByMethodReadFileCSVTest() throws TooShortPasswordException, IOException {

        Map<String, User> saveUserListTest = new HashMap<>();
        saveUserListTest.put("login1", new User("login1", "haslo1"));
        saveUserListTest.put("login2", new User("login2", "haslo2"));

        UserFileManager userFileManager = new UserFileManager();
        userFileManager.saveUserToFileCSV(saveUserListTest);

        Map<String, User> loadUserListTest = new HashMap<>();
        loadUserListTest = userFileManager.readUserFromFileCsv();

        assertEquals(saveUserListTest, loadUserListTest);
    }


    @Test
    public void saveAuctionToListAndChechResultByMethodReadFileCSVTest() throws TooShortPasswordException, IOException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AuctionId0Exception {
        User user1 = new User("login1", "haslo1");
        Map<String, User> saveUserToFileCSVTEST = new HashMap<>();
        saveUserToFileCSVTEST.put(user1.getLogin(), user1);
        UserFileManager userFileManager = new UserFileManager();
        userFileManager.ExistFileUserCSV();
        userFileManager.saveUserToFileCSV(saveUserToFileCSVTEST);
        Map<String, User> loadUserListTest = new HashMap<>();
        loadUserListTest = userFileManager.readUserFromFileCsv();
        UserList userList = UserList.getInstance();

        Auction auction1 = new Auction(user1, "Auction1", "Description1", BigDecimal.valueOf(100), new Category("Laptopy"), 10);

        Map<String, Auction> saveAuctionToMapTest = new HashMap<>();
        saveAuctionToMapTest.put("login1", auction1);

        AuctionFileManager auctionFileManager = new AuctionFileManager();
        auctionFileManager.saveAuctionToFileCSV(saveAuctionToMapTest);

        Map<String, Auction> loadAuctionListTest = new HashMap<>();
        loadAuctionListTest = auctionFileManager.readAuctionFromFileCsv();

        assertEquals(saveAuctionToMapTest, loadAuctionListTest);
    }
}

