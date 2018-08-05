package Helpers;

import Controllers.UserList;
import Exceptions.*;
import Models.Auction;
import Models.Category;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AuctionWinnerFileManager {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";

    public void saveAuctionToFileCSV(Map<Integer, Auction> map) throws IOException {

        String fileName = "AuctionWinnerList.csv";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
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

    public Map<Integer, Auction> readAuctionFromFileCsv() throws TooShortPasswordException, IOException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AuctionId0Exception {

        String fileName = "AuctionWinnerList.csv";
        String line = "";
        String cvsSplitBy = ",";

        Map<Integer, Auction> map = new HashMap<>();

        UserList userList = UserList.getInstance();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                    Auction auction = new Auction(UserList.getInstance().getUserList().get(data[USER_LOGIN]), data[TITLE], data[DESCRIPTION], new BigDecimal(data[STARTING_PRICE]), new Category(data[CATEGORY]), Integer.valueOf(data[AUCTION_ID]));
                    map.put(Integer.valueOf(data[AUCTION_ID]), auction);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void ExistFileAuctionCSV() throws IOException {

        String fileName = "AuctionWinnerList.csv";
        File file = new File(fileName);
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
    }

}
