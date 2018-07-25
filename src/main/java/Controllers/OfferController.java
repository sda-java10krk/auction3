package Controllers;

import Exceptions.AddingOfferToOwnAuction;
import Exceptions.NegativeOfferPriceException;
import Exceptions.OfferTooLowException;
import Models.Auction;
import Models.Offers;
import Models.User;

import java.math.BigDecimal;


public class OfferController {



        public Offers creatingOffer(User user, BigDecimal price) throws NegativeOfferPriceException {

            Offers offer = new Offers(user,price);

            return offer;
        }

        public void addOffer(Auction auction, Offers offer) throws OfferTooLowException, AddingOfferToOwnAuction {

            auction.addOffer(offer);

        }



}
