import Exceptions.EmptyDescriptionException;
import Exceptions.EmptyTitleException;
import Exceptions.SubcategoryPresentException;
import Exceptions.TooLowPriceException;

import java.math.BigDecimal;
import java.util.Scanner;

public class AuctionControllers {

    public Auction createAuction(User user, String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException, TooLowPriceException, EmptyTitleException, EmptyDescriptionException {

        Auction auction = new Auction(user,title,description,startingPrice,category);

        addAuctions(auction);

        return auction;
    }

    public void addAuctions(Auction auction) throws SubcategoryPresentException {
        auction.addingAuction(auction);
    }

    public void removingAuction(Auction auction){
        auction.removingAuction(auction);
    }
}
