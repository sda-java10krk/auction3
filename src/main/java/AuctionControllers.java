import Exceptions.SubcategoryPresentException;

import java.math.BigDecimal;
import java.util.Scanner;

public class AuctionControllers {

    public Auction createAuction(String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException {
        
        Auction auction = new Auction(title,description,startingPrice,category);


        return auction;
    }

    public void addAuctions(Auction auction){
        auction.addingAuction(auction);
    }
}
