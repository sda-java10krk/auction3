package Helpers;

import Controllers.UserList;
import Models.Auction;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;

public class AuctionFileCounterManager {

    private static final String SEPARATOR = ",";

    public void saveAuctionCounterToFileCSV(Integer counter) throws IOException {

        String fileName = "AuctionCounterFile.csv";
        FileWriter fileWriter = null;

        try {
                fileWriter = new FileWriter(fileName);
                fileWriter.append(String.valueOf(counter));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final int AUCTION_ID = 0;

    public Integer readAuctionCounterFromFileCsv() {

        String fileName = "AuctionCounterFile.csv";
        String line = "";
        String cvsSplitBy = ",";
        Integer auctionID =1;

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                    auctionID = Integer.valueOf(data[AUCTION_ID]);
                    auctionID++;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return auctionID;
    }


    public void ExistFileAuctionCounterCSV() throws IOException {

        String fileName = "AuctionCounterFile.csv";
        File file = new File(fileName);
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
    }
}
