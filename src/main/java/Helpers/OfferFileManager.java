package Helpers;

import Controllers.UserList;
import Exceptions.*;
import Models.Auction;
import Models.Category;
import Models.Offer;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OfferFileManager {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";

    public void saveOfferToFileCSV(Map<Integer, Offer> map) throws IOException {

        String fileName = "OfferList.csv";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            for (Offer offer : map.values()) {
                //fileWriter.append(String.valueOf(Integer));
                fileWriter.append(SEPARATOR);
                fileWriter.append(offer.getUser().getLogin());
                fileWriter.append(SEPARATOR);
                fileWriter.append(String.valueOf(offer.getPrice()));
                fileWriter.append(SEPARATOR);
                fileWriter.append(String.valueOf(offer.getId()));
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
    private static final int PRICE = 1;
    private static final int OFFER_ID = 2;
    private static final int AUCTION_ID = 3;

    public Map<Integer, Offer> readOfferFromFileCsv() throws TooShortPasswordException, IOException, EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AuctionId0Exception, NegativeOfferPriceException, OfferTooLowException {

        String fileName = "OfferList.csv";
        String line = "";
        String cvsSplitBy = ",";

        Map<Integer, Offer> map = new HashMap<>();

        UserList userList = UserList.getInstance();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                   Offer offer = new Offer(UserList.getInstance().getUserList().get(data[USER_LOGIN]), new BigDecimal(data[PRICE]), Integer.valueOf(data[OFFER_ID]),Integer.valueOf(data [AUCTION_ID]));
                    map.put(Integer.valueOf(data[AUCTION_ID]), offer);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void ExistFileOfferCSV() throws IOException {

        String fileName = "OfferList.csv";
        File file = new File(fileName);
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
    }
}
