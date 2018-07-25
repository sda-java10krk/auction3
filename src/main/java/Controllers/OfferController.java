package Controllers;

import Exceptions.AddingOfferToOwnAuction;
import Exceptions.NegativeOfferPriceException;
import Exceptions.OfferTooLowException;
import Models.Auction;
import Models.Offer;
import Models.User;

import java.math.BigDecimal;


public class OfferController {



        public Offer creatingOffer(User user, BigDecimal price) throws NegativeOfferPriceException {

            Offer offer = new Offer(user,price);

            return offer;
        }

        public void addOffer(Auction auction, Offer offer) throws OfferTooLowException, AddingOfferToOwnAuction {

            auction.addOffer(offer);

        }



}
