package Models;

import java.util.Map;

public class AuctionsDatabase {
    private static AuctionsDatabase instance;
    private Map<String,Auction> currentAuctionsMap;
    private Map<String,Auction> winningAuctionsMap;


    public static AuctionsDatabase getInstance(){
        if (instance == null){
            instance = new AuctionsDatabase();
        }
        return instance;
    }

    public void addAuction(Auction auction){


    }



}
