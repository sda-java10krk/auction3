package Helpers;

import Models.Auction;
import Models.Category;
import Models.Offer;
import Models.User;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AuctionFileManager {

    private static final String COMMA_SEPARATOR =",";
    private static final String NEW_LINE_SEPARATOR ="\n";
    private static final String PARAMETERS = "currentUserLogin,title,description,categoryName,amount";
    private static AuctionFileManager instance;

    private AuctionFileManager (){
    }

    public static AuctionFileManager getInstance (){
        if (instance == null){
            instance = new AuctionFileManager ();
        }
        return instance;
    }

    public void writeCsvFile (String filename, Auction auction){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filename);

        fileWriter.append(PARAMETERS.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            fileWriter.append(auction.getUser().getLogin());
            fileWriter.append(COMMA_SEPARATOR);
            fileWriter.append(auction.getTitle());
            fileWriter.append(COMMA_SEPARATOR);
            fileWriter.append(auction.getDescription());
            fileWriter.append(COMMA_SEPARATOR);
            fileWriter.append(auction.getStartingPrice().toString());
            fileWriter.append(COMMA_SEPARATOR);
            fileWriter.append(auction.getCategory().toString());
            fileWriter.append(COMMA_SEPARATOR);
            fileWriter.append(auction.getOffersList().toString());
            fileWriter.append(COMMA_SEPARATOR);
            fileWriter.append(auction.getCurrentOffer().toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        }
    }

