package Models;

import Exceptions.NegativeOfferPriceException;
import Models.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Offer implements Serializable {


    private User user;
    private BigDecimal price;
    private int id=0;
    private static Offer instance;
    public Map<String,Offer> AllOfferOfUser;
    public List<Offer> AllOffer = new ArrayList<>();


    public Offer() {
    }


    public static Offer getInstance() throws NegativeOfferPriceException {
        if(instance==null){
            instance= new Offer();
        }
        return instance;
    }

    public Map<String, Offer> getAllOfferOfUser() {
        return AllOfferOfUser;
    }

//    public Map AllUsersOffer(User user, Offer offer) {
//        return AllOfferOfUser;
//    }

    public Offer(User user, BigDecimal price,int id) throws NegativeOfferPriceException {
        this.user = user;
        if(price.compareTo(BigDecimal.valueOf(0))<0){
            throw new NegativeOfferPriceException();
        }
        this.price = price;
        this.id = id;
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
}
