package Models;

import java.util.*;

public class OfferDatabase {
    private static OfferDatabase instance;
    public Map<String,Offer> AllOfferOfUser;
    public List<Offer>AllOffer;


    public static OfferDatabase getInstance() {
        if (instance == null) {
            instance = new OfferDatabase();
        }
        return instance;
    }
}


