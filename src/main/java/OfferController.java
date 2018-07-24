
import Exceptions.OfferTooLowException;

import java.math.BigDecimal;


public class OfferController {



        public Offers creatingOffer(User user, BigDecimal price){

            Offers offer = new Offers(user,price);

            return offer;
        }

        public void addingOffer(Auction auction,Offers offer) throws OfferTooLowException {

            auction.addingOffer(offer);

        }



}
