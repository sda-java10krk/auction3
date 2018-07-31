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
        public void saveUserToListAndChechResultByMethodReadFileCSVTest () throws TooShortPasswordException, IOException {

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
    public void saveAuctionToListAndChechResultByMethodReadFileCSVTest () throws TooShortPasswordException, IOException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        User user1 = new User ("login1","haslo1");

        Auction auction1 = new Auction(user1,"Auction1","Description1",BigDecimal.valueOf(100),new Category("Laptopy"),10);

        Map<String, Auction> saveAuctionToMapTest = new HashMap<>();
        saveAuctionToMapTest.put("login1",auction1);

        AuctionFileManager auctionFileManager = new AuctionFileManager();
        auctionFileManager.saveAuctionToFileCSV(saveAuctionToMapTest);

        Map<String,Auction> loadUserListTest = new HashMap<>();
        loadUserListTest = auctionFileManager.readAuctionFromFileCsv();


        assertEquals(saveAuctionToMapTest, loadUserListTest);
    }

//        public void saveAuctionAndOffersAndChechResultByMethodReadFile () throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, TooShortPasswordException, NegativeOfferPriceException, AddingOfferToOwnAuction, OfferTooLowException {
//
//            List<Auction> auctionList = new LinkedList<>();
//
//            Auction auction = new Auction(new User("login", "password"), "title", "description", BigDecimal.valueOf(100), new Category("category"));
//
//            auction.addOffer(new Offer(new User("1", "password"), BigDecimal.valueOf(101)));
//            auction.addOffer(new Offer(new User("2", "password"), BigDecimal.valueOf(202)));
//            auction.addOffer(new Offer(new User("3", "password"), BigDecimal.valueOf(303)));
//            auctionList.add(auction);
//
//            SaveReadManager saveReadManager = new SaveReadManager();
//            saveReadManager.saveOffersToAuction(auctionList);
//
//            LinkedList<Auction> readList = saveReadManager.readAuctionToOffers();
//
//            assertEquals(auctionList, readList);
//
//        }
    }

