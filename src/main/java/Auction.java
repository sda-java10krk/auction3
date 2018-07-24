import Exceptions.*;
import sun.jvm.hotspot.debugger.AddressException;

import java.math.BigDecimal;
import java.util.List;

public class Auction {


    private User user;
    private String title;
    private String description;
    private BigDecimal startingPrice;
    private Category category;
    private List<Offers> offersList;
    private Offers currentOffer;


    public Auction(User user, String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException, TooLowPriceException, EmptyTitleException, EmptyDescriptionException {

        this.user = user;

        if(title.length()==0){
            throw new EmptyTitleException();
        }
        this.title = title;
        if(description.length()==0){
            throw new EmptyDescriptionException();
        }
        this.description = description;

        if(startingPrice.compareTo(BigDecimal.valueOf(0))>0){
            this.startingPrice = startingPrice;
        }else{
            throw new TooLowPriceException();
        }
        if(category.isSubcategoryPresent()){
            throw new SubcategoryPresentException();
        }
        this.category = category;

    }

    public void addingOffer(Offers offer) throws OfferTooLowException, AddingOfferToOwnAuction{

        if(offer.getUser().equals(user)){
            throw new AddingOfferToOwnAuction();
        }
        if(this.currentOffer!=null && offer.getPrice().compareTo(this.startingPrice)<=0){

            throw new OfferTooLowException();

        }else{
            this.offersList.add(offer);
        }
    }

    public boolean auctionWinnerChecking(Offers offer){
        if(this.offersList.size()==3){
            return true;
        }else{
            return false;
        }
    }

    public void addingAuction(Auction auction){
        category.addAuction(auction);
    }

    public void removingAuction(Auction auction){
        category.removingAuction(auction);
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCurrentOffer(Offers currentOffer) {
        this.currentOffer = currentOffer;
    }
}
/*
Każdy użytkownik może wystawić aukcję. Aukcja ma: tytuł, opis, cenę początkową, kategorię.
Każde z tych pól może mieć wartość, która się powtarza, tj. np. mogą być w systemie dwie aukcje "Opel Astra" za 1000zł tego samego użytkownika.


 */