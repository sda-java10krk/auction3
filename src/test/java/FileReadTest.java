
import Exceptions.*;
import Models.Auction;
import Models.Category;
import Models.Offer;
import Models.Offer;

import Models.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReadTest {


    public static final String FILE_NAME1 = "UserList.txt";
    public static final String FILE_NAME2 ="AuctionsList.txt";

    @Test
    public void saveUserToListTestAndChechResultByMethodReadFile () throws TooShortPasswordException {
        Map<String, User> userListTest = new HashMap<>();
        User userTest = new User ("login","haslo1");
        userListTest.put("login", new User("Login","hasło1"));

        FileManager fileManager = new FileManager();
        fileManager.saveUserToFile(userListTest);

        HashMap <String,User> readUser = fileManager.readUserFromFile();
        assertEquals(userListTest, readUser);
    }



    @Test
    public void saveAuctionAndOffersAndChechResultByMethodReadFile () throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, TooShortPasswordException, NegativeOfferPriceException, AddingOfferToOwnAuction, OfferTooLowException {
        List<Auction> auctionList = new LinkedList<>();

        Auction auction = new Auction(new User ("login","password"),"title","description",BigDecimal.valueOf(100),new Category("category"));

        auction.addOffer(new Offer(new User ("1","password"),BigDecimal.valueOf(101)));
        auction.addOffer(new Offer(new User ("2","password"),BigDecimal.valueOf(202)));
        auction.addOffer(new Offer(new User ("3","password"),BigDecimal.valueOf(303)));
        auctionList.add(auction);

        FileManager fileManager = new FileManager();
        fileManager.saveOffersForAuction(auctionList);

        LinkedList<Auction> readList = fileManager.readAuctionToOffers();
        assertEquals(auctionList, readList);
    }
}
