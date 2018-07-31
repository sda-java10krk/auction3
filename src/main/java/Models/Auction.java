package Models;

import Exceptions.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Auction implements Serializable {

    private User user;
    private String title;
    private String description;
    private BigDecimal startingPrice;
    private Category category;
    private List<Offer> offersList;
    private Offer currentOffer;
    private int id;


    public Auction(User user, String title, String description, BigDecimal startingPrice, Category category, int id) throws SubcategoryPresentException, TooLowPriceException, EmptyTitleException, EmptyDescriptionException, AuctionId0Exception {

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

        if(id==0){
            throw new AuctionId0Exception();
        }
        this.id = id;
    }

    public boolean addOffer(Offer offer) throws OfferTooLowException, AddingOfferToOwnAuction{

        if(offer.getUser().equals(user)){
            throw new AddingOfferToOwnAuction();
        }
        if(this.currentOffer!=null && offer.getPrice().compareTo(this.currentOffer.getPrice())<=0 || offer.getPrice().compareTo(this.startingPrice)<=0){
            throw new OfferTooLowException();
        }else{
            if(auctionWinnerChecking()) {
                return false;
            }else {
                this.offersList.add(offer);
                this.currentOffer = offer;
            }
        }

        return true;
    }


    public boolean auctionWinnerChecking(){
        if(this.offersList.size()==3){
            return true;
        }else{
            return false;
        }
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

    public List<Offer> getOffersList() {
        return offersList;
    }

    public Offer getCurrentOffer() {
        return currentOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return Objects.equals(user, auction.user) &&
                Objects.equals(title, auction.title) &&
                Objects.equals(description, auction.description)  &&
                Objects.equals(startingPrice, auction.startingPrice)  &&
                Objects.equals(category, auction.category)  &&
                Objects.equals(offersList, auction.offersList) &&
                Objects.equals(currentOffer, auction.currentOffer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, title, description, startingPrice, category, offersList, currentOffer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auction{");
        sb.append("user=").append(user);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", startingPrice=").append(startingPrice);
        sb.append(", category=").append(category);
        sb.append(", offersList=").append(offersList);
        sb.append(", currentOffer=").append(currentOffer);
        sb.append('}');
        return sb.toString();
    }
}
/*
Każdy użytkownik może wystawić aukcję. Aukcja ma: tytuł, opis, cenę początkową, kategorię.
Każde z tych pól może mieć wartość, która się powtarza, tj. np. mogą być w systemie dwie aukcje "Opel Astra" za 1000zł tego samego użytkownika.


 */