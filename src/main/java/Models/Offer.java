package Models;

import Exceptions.NegativeOfferPriceException;
import Exceptions.OfferTooLowException;
import Exceptions.TooLowPriceException;
import Models.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


public class Offer implements Serializable {


    private User user;
    private BigDecimal price;
    private int id=0;


    public Offer(User user, BigDecimal price,int id, int idAuction) throws OfferTooLowException {
        this.user = user;
        if(price.compareTo(BigDecimal.valueOf(0))<0){
            throw new OfferTooLowException();
        }
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(user, offer.user) &&
                Objects.equals(price, offer.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, price);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "user=" + user +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
