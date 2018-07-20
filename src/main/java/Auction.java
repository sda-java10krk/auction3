import Exceptions.OfferTooLowException;
import Exceptions.SubcategoryPresentException;

import java.util.List;

public class Auction {
    private String title;
    private String description;
    private Long startingPrice;
    private Category category;
    private List<Offers> offersList;
    private Offers currentOffert;

    public Auction(String title, String description, Long startingPrice, Category category) throws SubcategoryPresentException {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        if(category.isSubcategoryPresent(category.toString())){
            throw new SubcategoryPresentException();
        }else{
            this.category = category;
        }
    }

    public void addingOffer(Offers offer) throws OfferTooLowException{
        if(this.currentOffert==null && currentOffert.getPrice()<offer.getPrice()){
            this.currentOffert = offer;
            this.offersList.add(offer);
        }
        throw new OfferTooLowException();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getStartingPrice() {
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