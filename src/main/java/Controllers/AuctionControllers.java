
package Controllers;


import Exceptions.*;
import Models.Auction;
import Models.AuctionsDatabase;
import Models.Category;
import Models.User;


import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class AuctionControllers {

    public static AuctionControllers instance;

    public static AuctionControllers getInstance() {
        if(instance == null){
            instance = new AuctionControllers();
        }
        return instance;
    }

    public Auction createAuction(User user, String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException, TooLowPriceException, EmptyTitleException, EmptyDescriptionException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {


        Auction auction = new Auction(user,title,description,startingPrice,category);

        category.addAuction(auction);

        return auction;
    }

    public String showSpecificAuction(Category category, String categoryName) throws NoSuchACategoryException {

        if(category.getName().equals(categoryName)){
            return category.getAuction().toString();
        }else{
            throw new NoSuchACategoryException();
        }
    }

    public void showMyListingAuction(){

        AuctionsDatabase.getInstance().getCurrentAuctions();



    }

}
