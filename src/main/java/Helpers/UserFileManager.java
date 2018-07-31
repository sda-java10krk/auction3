package Helpers;

import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Models.User;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;


public class UserFileManager {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";


    public void saveUserToFileCSV(Map<String, User> map) throws IOException {

        String fileName = "UserList2.csv";
        //UserFileManager.toEnoughtDiskSpace();
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            for (User user : map.values()) {
                fileWriter.append(user.getLogin());
                fileWriter.append(SEPARATOR);
                fileWriter.append(user.getPassword());
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
    private static final int USER_PASSWORD = 1;

    public Map<String, User> readUserFromFileCsv() throws TooShortPasswordException, IOException {

        String fileName = "UserList2.csv";
        String line = "";
        String cvsSplitBy = ",";
        Map <String,User> map = new HashMap<>();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                    User user = new User(data[USER_LOGIN], data[USER_PASSWORD]);
                    map.put(data[USER_LOGIN],user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    //jesli nie mozna zapisac do pliku bo za duzy to przekierowuje do zapisuje do pliku nr 2 lub 3
    public static void toEnoughtDiskSpace() throws IOException {
        //TODO jakaś metoda
        if (true) {
        } else {
            File file = new File("UserList2_secondList.csv");
            file.createNewFile();
        }
    }

    //TODO
    public static void fileUserListIsDamagedDuringReading() {

    }

    //TODO
    public static void fileUserListIsDamagedDuringSaving() {

    }

}

