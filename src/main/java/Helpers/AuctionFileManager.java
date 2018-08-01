package Helpers;

import Controllers.UserList;
import Exceptions.*;
import Models.Auction;
import Models.Category;
import Models.User;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AuctionFileManager {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";

    public void saveAuctionToFileCSV(Map<String, Auction> map) throws IOException {

        String fileName = "AuctionList.csv";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            for (Auction auction : map.values()) {

                fileWriter.append(auction.getUser().getLogin());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getTitle());
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getDescription());
                fileWriter.append(SEPARATOR);
                fileWriter.append(String.valueOf(auction.getStartingPrice()));
                fileWriter.append(SEPARATOR);
                fileWriter.append(auction.getCategory().toString());
                fileWriter.append(SEPARATOR);
                fileWriter.append(String.valueOf(auction.getId()));
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
    private static final int AUCTION_ID = 5;

    public Map<String, Auction> readAuctionFromFileCsv() throws TooShortPasswordException, IOException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AuctionId0Exception {

        String fileName = "AuctionList.csv";
        String line = "";
        String cvsSplitBy = ",";
        Map <String,Auction> map = new HashMap<>();
        UserList userList = UserList.getInstance();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                    Auction auction = new Auction(UserList.getInstance().getUserList().get(data[USER_LOGIN]), data[TITLE],data[DESCRIPTION], new BigDecimal(data[STARTING_PRICE]), new Category(data [CATEGORY]),Integer.parseInt(data[AUCTION_ID]));
                    map.put(data[USER_LOGIN],auction);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

//   public void saveOffersToAuction (List<Auction> list) {
//
//        String fileName2 = "AuctionsList.txt";
//        try {
//            FileOutputStream fileWriter2 = new FileOutputStream(fileName2);
//           ObjectOutputStream writer2 = new ObjectOutputStream(fileWriter2);
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

    public void ExistFileAuctionCSV() throws IOException {

       String  fileName = "AuctionFileCSV.csv";
        File file = new File(fileName);
        if(file.exists()) {
        } else {
            file.createNewFile();
        }
    }
}
