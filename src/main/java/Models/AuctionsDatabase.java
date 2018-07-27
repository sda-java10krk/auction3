package Models;

import Exceptions.AuctionNotEndedYetException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private AuctionsDatabase() {
        this.currentAuctionsMap = new HashMap<>();
        this.winningAuctionsMap = new HashMap<>();
    }

    public void addCurrentAuction(Auction auction){

        this.currentAuctionsMap.put(auction.getUser().getLogin(), auction);

    }

    public void addWiningAuction(Auction auction) throws AuctionNotEndedYetException{

        if(auction.auctionWinnerChecking()){
            this.winningAuctionsMap.put(auction.getUser().getLogin(),auction);
        }
        else{
            throw new AuctionNotEndedYetException();
        }

    }
    

    public List<Auction> getCurrentAuctions(){

        List<Auction> auctions = this.currentAuctionsMap.values().stream().collect(Collectors.toList());

        return auctions;
    }




}
