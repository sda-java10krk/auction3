package Helpers;

import Exceptions.TooShortPasswordException;
import Models.Auction;
import Models.User;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AuctionFileManager {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";


    public void saveAuctionToFileCSV(Map<User, Auction> map) throws IOException {

        String fileName = "AuctionList.csv";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            for (Auction auction : map.values()) {
                fileWriter.append(auction.getUser().toString());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getTitle());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getDescription());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getStartingPrice().toString());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getCategory().toString());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getOffersList().toString());    //TODO
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getCurrentOffer().toString()); // TODO
                fileWriter.append(NEW_LINE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static final int USER_LOGIN = 0;
    private static final int TITLE = 1;
    private static final int DESCRIPTION = 2;
    private static final int STARTING_PRICE = 3;
    private static final int CATEGORY = 4;
    private static final int OFFERS_LIST = 5;
    private static final int CURRENT_OFFER = 5;


}



//
//    public void saveOffersToAuction (List<Auction> list) {
//
//        String fileName2 = "AuctionsList.txt";
//        try {
//            FileOutputStream fileWriter2 = new FileOutputStream(fileName2);
//            ObjectOutputStream writer2 = new ObjectOutputStream(fileWriter2);
//            {
//                writer2.writeObject(list);
//            }
//        }
//        catch (FileNotFoundException e) {
//            System.err.println("Nie odnaleziono pliku " + fileName2);
//        } catch (IOException e) {
//            System.err.println("Błąd podczas zapisu danych do pliku " + fileName2);
//        }
//    }
//
//
//
//
//    public LinkedList<Auction> readAuctionToOffers () {
//
//        String fileName2 = "AuctionsList.txt";
//
//        try {
//            FileInputStream fileReader2 = new FileInputStream(fileName2);
//            ObjectInputStream reader2 = new ObjectInputStream(fileReader2);
//            {
//                return (LinkedList<Auction>) reader2.readObject();
//            }
//        } catch (FileNotFoundException e){
//            System.err.println("Nie odnaleziono pliku " + fileName2);
//        } catch (IOException e){
//            System.err.println("Błąd podczas odczytu danych z pliku " + fileName2);
//        } catch (ClassNotFoundException e) {
//            System.err.println("Nieprawidłowy format pliku");
//        }
//        return null ;
//    }

    public static void ExistFileAuction() throws IOException {

        String  fileName = "AuctionFileCSV.csx";

        if (fileName.e) {
        } else {
            File file = new File("UserList2_secondList.csv");
            file.createNewFile();
        }
    }
}
