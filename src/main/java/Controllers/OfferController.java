package Controllers;

import Exceptions.AddingOfferToOwnAuction;
import Exceptions.NegativeOfferPriceException;
import Exceptions.OfferTooLowException;
import Helpers.OfferFileManager;
import Helpers.OfferID;
import Models.Auction;
import Models.Offer;
import Models.User;

import java.io.IOException;
import java.math.BigDecimal;


public class OfferController {

        public Offer creatingOffer(User user, BigDecimal price,Integer offerId ,Integer auctionId) throws OfferTooLowException {

            Offer offer = new Offer(user,price,offerId , auctionId);
            return offer;
        }
// czy mam to rozumiec ze nazwalismy te funkcje addOffer i tak samo sie nazywa w Auction tylko tutaj wywoujemy

        public void addOffer(Auction auction,Offer offer) throws AddingOfferToOwnAuction, OfferTooLowException, NegativeOfferPriceException, IOException {
            auction.addOffer(auction, offer);
        }

}
