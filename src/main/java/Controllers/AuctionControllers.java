package Controllers;

import Exceptions.EmptyDescriptionException;
import Exceptions.EmptyTitleException;
import Exceptions.SubcategoryPresentException;
import Exceptions.TooLowPriceException;
import Models.Auction;
import Models.Category;
import Models.User;

import java.math.BigDecimal;

public class AuctionControllers {

    public Auction createAuction(User user, String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException, TooLowPriceException, EmptyTitleException, EmptyDescriptionException {


        Auction auction = new Auction(user,title,description,startingPrice,category);

        category.addAuction(auction);

        return auction;
    }

}
