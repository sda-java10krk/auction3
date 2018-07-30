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
        String fileName = "C:\\Users\\marcin\\IdeaProjects\\auction3\\UserList2.csv";

        UserFileManager.toEnoughtDiskSpace();

        FileWriter fileWriter = null;

        try {
            for (User user : map.values()) {
                fileWriter = new FileWriter(fileName);
                fileWriter.append(user.getLogin());
                fileWriter.append(SEPARATOR);
                fileWriter.append(user.getPassword());
                fileWriter.append(NEW_LINE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static final int USER_LOGIN = 0;
    private static final int USER_PASSWORD = 1;

    public User readUserFromFileCsv() throws TooShortPasswordException, IOException {

        UserFileManager.checkTheFileCsvUserExist();
        String fileName = "C:\\Users\\marcin\\IdeaProjects\\auction3\\UserList2.csv";
        //String line = "";
        String cvsSplitBy = ",";
        int lines = 0;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line = fileReader.readLine();
            while (line!= null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 0) {
                    User user = new User(data[USER_LOGIN], data[USER_PASSWORD]);
                    //NEW_LINE
                    UserList.getInstance().AddUserToListFromFile(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO
    // co zrobic z problemem dotyczacym ściezki bo przeciez u kazdego bedzie inna sciezka w zaleznosci gdzie ten plik
    // wiec pytanie czy mozna to jakos zautomatyzowac albo pomyslec nad tym czy nie lepiej jak plik bedzie juz
    // gotowy przed pierwszym otwarciem programu
    public static void checkTheFileCsvUserExist() throws IOException {
        File file = new File("C:\\Users\\marcin\\IdeaProjects\\auction3\\UserList2.csv");
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
    }


    //jesli nie mozna zapisac do pliku bo za duzy to przekierowuje do zapisuje do pliku nr 2 lub 3
    public static void toEnoughtDiskSpace() throws IOException {
        //TODO jakaś metoda
        if (true) {
        } else {
            File file = new File("C:\\Users\\marcin\\IdeaProjects\\auction3\\UserList2_secondList.csv");
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

