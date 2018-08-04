package Helpers;

import java.io.*;

public class OfferFileCounterManager {

    private static final String SEPARATOR = ",";

    public void saveOfferCounterToFileCSV(Integer counter) throws IOException {

        String fileName = "OfferCounterFile.csv";
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

    private static final int OFFER_ID = 0;

    public Integer readOfferCounterFromFileCsv() {

        String fileName = "OfferCounterFile.csv";
        String line = "";
        String cvsSplitBy = ",";
        Integer offerID = null;

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                    offerID = Integer.valueOf(data[OFFER_ID]);
                    offerID++;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return offerID;
    }


    public void ExistFileOfferCounterCSV() throws IOException {

        String fileName = "OfferCounterFile.csv";
        File file = new File(fileName);
        if (file.exists()) {
        } else {
            file.createNewFile();
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(fileName);
            Integer OfferID = 0;
            fileWriter.append(String.valueOf(OfferID));
            fileWriter.close();
        }
    }
}
