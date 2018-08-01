package Models;

import Exceptions.AuctionNotEndedYetException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuctionsDatabase {
    private static AuctionsDatabase instance;
    private Map<Integer,Auction> currentAuctionsMap;
    private Map<Integer,Auction> winningAuctionsMap;



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

        this.currentAuctionsMap.put(auction.getId(), auction);

    }

    @Override
    public String toString() {
        return "AuctionsDatabase{" +
                "currentAuctionsMap=" + currentAuctionsMap +
                ", winningAuctionsMap=" + winningAuctionsMap +
                '}';
    }


    public Map<Integer, Auction> getCurrentAuctionsMap() {
        return currentAuctionsMap;
    }

    public Map<Integer, Auction> getWinningAuctionsMap() {
        return winningAuctionsMap;
    }

    public void addWiningAuction(Auction auction) throws AuctionNotEndedYetException{

        if(auction.auctionWinnerChecking()){
            this.winningAuctionsMap.put(auction.getId(),auction);
        }
        else{
            throw new AuctionNotEndedYetException();
        }

    }

    public List<Auction> getCurrentAuctions(User user){
        List<Auction> auctions = new ArrayList<>();
        for (Map.Entry<Integer, Auction> entry : currentAuctionsMap.entrySet()) {
            if(currentAuctionsMap.containsValue(user.getLogin())){
                auctions.add(entry.getValue());
            }
        }
        return auctions;
    }

    public void setCurrentAuctionsMap(Map<Integer, Auction> currentAuctionsMap) {
        this.currentAuctionsMap = currentAuctionsMap;
    }

    public void setWinningAuctionsMap(Map<Integer, Auction> winningAuctionsMap) {
        this.winningAuctionsMap = winningAuctionsMap;
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
