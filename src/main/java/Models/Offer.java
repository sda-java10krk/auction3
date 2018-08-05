package Models;

import Exceptions.NegativeOfferPriceException;
import Exceptions.OfferTooLowException;
import Exceptions.TooLowPriceException;
import Helpers.OfferID;
import Models.User;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


public class Offer implements Serializable {


    private User user;
    private BigDecimal price;
    private Integer id;
    private Integer idAuction;


    public Offer(User user, BigDecimal price, Integer id ,Integer idAuction) throws OfferTooLowException {
        this.user = user;
        if(price.compareTo(BigDecimal.valueOf(0))<0){
            throw new OfferTooLowException();
        }
        this.price = price;
        this.id = id;
        this.idAuction = idAuction;
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

    public Integer getIdAuction() {
        return idAuction;
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
        return new ToStringBuilder(this)
                .append("user", user)
                .append("price", price)
                .append("id", id)
                .append("idAuction", idAuction)
                .toString();
    }
}
