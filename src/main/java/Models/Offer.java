package Models;

import Exceptions.NegativeOfferPriceException;
import Models.User;

import java.math.BigDecimal;


public class Offer{


    private User user;
    private BigDecimal price;

    public Offer(User user, BigDecimal price) throws NegativeOfferPriceException {
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
