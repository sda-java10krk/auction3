package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferDatabase {
    private static OfferDatabase instance;
    public Map<String,Offer> AllOfferOfUser;
    public Map<String,Auction> AllAuctionOfUser;
    public List<Auction>AlAuctionOfUser;


    public static OfferDatabase getInstance(){
        if(instance==null){
            instance= new OfferDatabase();
        }
        return instance;
    }

    private OfferDatabase() {
        this.AllAuctionOfUser= new HashMap<>();
        this.AllOfferOfUser= new HashMap<>();
    }

    public void AddAuctionOfUser(User user,Auction auction){
        this.AllAuctionOfUser.put(user.getLogin(),auction);
    }

    public void AddOfferOfUsser(User user, Offer offer){
        this.AllOfferOfUser.put(user.getLogin(),offer);
    }


    public List<Auction> getAllAuctionsOfUser(User user){
        List<Auction> userAuctions = new ArrayList<>();
        for (Map.Entry<String, Auction> entry : AllAuctionOfUser.entrySet()) {
            if(AllAuctionOfUser.containsValue(user.getLogin())){
                userAuctions.add(entry.getValue());
            }
        }
        return userAuctions;
    }

    public List<Offer> getAllOfferOfUser(User user){
        List<Offer> userOffer = new ArrayList<>();
        for (Map.Entry<String, Offer> entry : AllOfferOfUser.entrySet()) {
            if(AllOfferOfUser.containsValue(user.getLogin())){
               userOffer.add(entry.getValue());
            }
        }
        return userOffer;
    }

}
