import Exceptions.SubcategoryPresentException;
import Exceptions.TooLowPriceException;

import java.math.BigDecimal;
import java.util.Scanner;

public class AuctionControllers {

    public Auction createAuction(String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException, TooLowPriceException {

        Auction auction = new Auction(title,description,startingPrice,category);

        addAuctions(auction);

        return auction;
    }

    public void addAuctions(Auction auction){
        auction.addingAuction(auction);
    }

    public void removingAuction(Auction auction){
        auction.removingAuction(auction);
    }
}
