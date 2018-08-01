package Helpers;

import Models.AuctionsDatabase;

public class AuctionID {

    private static AuctionID instance;
    private int id;

    public static AuctionID getInstance(){
        if (instance == null){
            instance = new AuctionID();
        }
        return instance;
    }

    public int getId(){

        id++;
        return id;

    }
}
