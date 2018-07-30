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
// czy mam to rozumiec ze nazwalismy te funkcje addOffer i tak samo sie nazywa w Auction tylko tutaj wywoujemy
        public void addOffer(Auction auction, Offer offer) throws OfferTooLowException, AddingOfferToOwnAuction {
            auction.addOffer(offer);

        }



}
