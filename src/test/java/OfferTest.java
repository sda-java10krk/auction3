import Controllers.AuctionControllers;
import Controllers.OfferController;
import Exceptions.*;
import Helpers.OfferID;
import Models.Auction;
import Models.Category;
import Models.Offer;
import Models.User;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OfferTest {

//    @Test
//    public void returnTrueIfPossibleAddOfferTest() throws Exception {
//        User user = new User("Filip", "qwerty");
//        int counter = 1;
//        Integer counterOffer = 1;
//        Auction auction = AuctionControllers.getInstance().createAuction(user, "Opel", "sdadas", new BigDecimal(6000), new Category("Osobowe"),counter);
//
//        User user1 = new User("Filip1", "qwerty");
//        OfferController offerController = new OfferController();
//        offerController.addOffer(auction, offerController.creatingOffer(user1, new BigDecimal(10000),counterOffer,auction));
//
//        Offer offer = auction.getOffersList().get(0);
//    }
//
//    @Test(expected = OfferTooLowException.class)
//    public void createofferTest() throws Exception {
//        User user = new User("Filip", "qwerty");
//        int counter = 1;
//        Integer counterOffer = 2;
//        Auction auction = AuctionControllers.getInstance().createAuction(user, "Opel", "sdadas", new BigDecimal(4000), new Category("Osobowe"),counter);
//        User user1 = new User("Filip1", "qwerty");
//        OfferController offerController = new OfferController();
//        Offer offer = offerController.creatingOffer(user1,new BigDecimal(-50), counterOffer,auction);
//        offerController.addOffer(auction,offer);
//
//    }

}
