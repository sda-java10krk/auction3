package Controllers;

import Exceptions.AddingOfferToOwnAuction;
import Exceptions.NegativeOfferPriceException;
import Exceptions.OfferTooLowException;
import Helpers.OfferID;
import Models.Auction;
import Models.Offer;
import Models.User;

import java.math.BigDecimal;
import java.util.Map;


public class OfferController {

        public Offer creatingOffer(User user, BigDecimal price) throws NegativeOfferPriceException {

            Offer offer = new Offer(user,price, OfferID.getInstance().getId());


            return offer;
        }
// czy mam to rozumiec ze nazwalismy te funkcje addOffer i tak samo sie nazywa w Auction tylko tutaj wywoujemy

        public void addOffer(Auction auction,Offer offer) throws AddingOfferToOwnAuction, OfferTooLowException, NegativeOfferPriceException {
            auction.addOffer(offer);
            offer.getAllOfferOfAuction().put(auction.getId(),offer);

        }

}
