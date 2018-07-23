import Exceptions.OfferTooLowException;
import Exceptions.SubcategoryPresentException;

import java.math.BigDecimal;
import java.util.List;

public class Auction {

    private String title;
    private String description;
    private BigDecimal startingPrice;
    private Category category;
    private List<Offers> offersList;
    private Offers currentOffer;

    public Auction(String title, String description, BigDecimal startingPrice, Category category) throws SubcategoryPresentException {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        if(category.isSubcategoryPresent()){
            throw new SubcategoryPresentException();
        }else{
            this.category = category;
        }
    }


    public void addingOffer(Offers offer) throws OfferTooLowException{
        if(this.currentOffer==null && currentOffer.getPrice().compareTo(offer.getPrice())<0){
            this.currentOffer = offer;
            this.offersList.add(offer);
            if(auctionWinnerChecking(offer)){

            }
        }
        throw new OfferTooLowException();
    }

    public boolean auctionWinnerChecking(Offers offer){
        if(offersList.size()==3){
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
}
/*
Każdy użytkownik może wystawić aukcję. Aukcja ma: tytuł, opis, cenę początkową, kategorię.
Każde z tych pól może mieć wartość, która się powtarza, tj. np. mogą być w systemie dwie aukcje "Opel Astra" za 1000zł tego samego użytkownika.


 */