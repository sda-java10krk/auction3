package Models;

import Exceptions.NegativeOfferPriceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferDatabase {
    private static OfferDatabase instance;
    private Map<Integer,Offer> allOfferOfAuction;


    public static OfferDatabase getInstance() throws NegativeOfferPriceException {
        if (instance == null) {
            instance = new OfferDatabase();
        }
        return instance;
    }

        private OfferDatabase(){
            this.allOfferOfAuction = new HashMap<>();
        }

        public void addOffert(Auction auction,Offer offer){
            this.allOfferOfAuction.put(auction.getId(),offer);
        }
     public Map<Integer, Offer> getAllOfferOfAuction() {
        return allOfferOfAuction;
    }

    public List<Offer> getallOfferOfAuction(Auction auction){
        List<Offer> offerts = new ArrayList<>();
        for (Map.Entry<Integer, Offer> entry : allOfferOfAuction.entrySet()) {
            if(allOfferOfAuction.containsValue(auction.getId())){
                offerts.add(entry.getValue());
            }
        }
        return offerts;
    }
    }

