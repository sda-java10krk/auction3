
package Controllers;

import Exceptions.*;
import Helpers.AuctionFileManager;
import Models.Auction;
import Models.AuctionsDatabase;
import Models.Category;
import Models.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuctionControllers {

    public static AuctionControllers instance;
    public Map<Integer,Auction> AuctionList;
    private AuctionFileManager auctionFileManager = new AuctionFileManager();

    public static AuctionControllers getInstance() {
        if (instance == null) {
            instance = new AuctionControllers();
        }
        return instance;
    }

    public void AuctionList() {
        this.AuctionList = new HashMap<>();
    }

    public Auction createAuction(User user, String title, String description, BigDecimal startingPrice, Category category, Integer counter) throws SubcategoryPresentException, TooLowPriceException, EmptyTitleException, EmptyDescriptionException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AuctionId0Exception, IOException {

        Auction auction = new Auction(user, title, description, startingPrice, category, counter);
       category.addAuction(auction);
       AuctionsDatabase.getInstance().addCurrentAuction(auction);
        auctionFileManager.saveAuctionToFileCSV(AuctionsDatabase.getInstance().getCurrentAuctionsMap());

        return auction;
    }

    public Set<Auction> showSpecificAuction(Category category) throws NoSuchACategoryException {

        if (category.getAuction() == null) {
            throw new NoSuchACategoryException();
        }
        return category.getAuction();

    }


}
