package Models;

import Exceptions.NegativeOfferPriceException;
import Models.User;

import java.math.BigDecimal;


public class Offers {


    private User user;
    private BigDecimal price;

    public Offers(User user, BigDecimal price) throws NegativeOfferPriceException {
        this.user = user;
        if(price.compareTo(BigDecimal.valueOf(0))<0){
            throw new NegativeOfferPriceException();
        }
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getPrice() {
        return price;
    }


}
