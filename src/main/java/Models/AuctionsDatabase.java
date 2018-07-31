package Models;

import Exceptions.AuctionNotEndedYetException;

import java.util.ArrayList;
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

    public Map<String, Auction> getCurrentAuctionsMap() {
        return currentAuctionsMap;
    }

    public Map<String, Auction> getWinningAuctionsMap() {
        return winningAuctionsMap;
    }

    public void addWiningAuction(Auction auction) throws AuctionNotEndedYetException{

        if(auction.auctionWinnerChecking()){
            this.winningAuctionsMap.put(auction.getUser().getLogin(),auction);
        }
        else{
            throw new AuctionNotEndedYetException();
        }

    }

    public List<Auction> getCurrentAuctions(User user){
        List<Auction> auctions = new ArrayList<>();
        for (Map.Entry<String, Auction> entry : currentAuctionsMap.entrySet()) {
            if(currentAuctionsMap.containsValue(user.getLogin())){
                auctions.add(entry.getValue());
            }
        }
        return auctions;
    }
//
//
//    public List<Auction> getWinningAuctions(){
//        List<Auction> auctions = new ArrayList<>();
//        for (Map.Entry<String, Auction> entry : winningAuctionsMap.entrySet()) {
//            auctions.add(entry.getValue());
//        }
//        return auctions;
//    }




}
