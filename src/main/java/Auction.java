import Exceptions.*;
import sun.jvm.hotspot.debugger.AddressException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

        this.offersList = new LinkedList<>();
    }

    public boolean addingOffer(Offers offer) throws OfferTooLowException, AddingOfferToOwnAuction{

        if(offer.getUser().equals(user)){
            throw new AddingOfferToOwnAuction();
        }
        if(this.currentOffer!=null && offer.getPrice().compareTo(this.currentOffer.getPrice())<=0 || offer.getPrice().compareTo(this.startingPrice)<=0){
            throw new OfferTooLowException();
        }else{
            if(auctionWinnerChecking(offer)) {
                return false;
            }else {
                this.offersList.add(offer);
                this.currentOffer = offer;
            }
        }

        return true;
    }

    public boolean auctionWinnerChecking(Offers offer){
        if(this.offersList.size()==3){
            return true;
        }else{
            return false;
        }
    }

    public void addingAuction(Auction auction) throws SubcategoryPresentException {
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

    public List<Offers> getOffersList() {
        return offersList;
    }

    public Offers getCurrentOffer() {
        return currentOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return Objects.equals(user, auction.user) &&
                Objects.equals(title, auction.title) &&
                Objects.equals(description, auction.description) &&
                Objects.equals(startingPrice, auction.startingPrice) &&
                Objects.equals(category, auction.category) &&
                Objects.equals(offersList, auction.offersList) &&
                Objects.equals(currentOffer, auction.currentOffer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, title, description, startingPrice, category, offersList, currentOffer);
    }
}
/*
Każdy użytkownik może wystawić aukcję. Aukcja ma: tytuł, opis, cenę początkową, kategorię.
Każde z tych pól może mieć wartość, która się powtarza, tj. np. mogą być w systemie dwie aukcje "Opel Astra" za 1000zł tego samego użytkownika.


 */