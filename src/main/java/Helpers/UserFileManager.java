package Helpers;

import Controllers.UserList;
import Exceptions.TooShortPasswordException;
import Models.User;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class UserFileManager {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";
    private static final String PARAMETERS = "login,password";


    public void saveUserToFileCSV(Map<String, User> map) throws IOException {
        String fileName = "UserList2.csv";
        FileWriter fileWriter = null;

        try {
            for (User user : map.values()) {
                fileWriter = new FileWriter(fileName);
                fileWriter.append(PARAMETERS.toString());
                fileWriter.append(NEW_LINE);
                fileWriter.append(user.getLogin());
                fileWriter.append(SEPARATOR);
                fileWriter.append(user.getPassword());
                fileWriter.append(SEPARATOR);
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


    public HashMap<String, User> readUserFromFile() throws TooShortPasswordException, IOException {
        UserFileManager.checkTheFileUserExist();
        String fileName = "UserList2.csv";
        BufferedReader fileReader = null;
        String line = "";

        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                if (data.length > 0) {
                    User user = new User(data[USER_LOGIN], data[USER_PASSWORD]);
                    // zobaczyc czy dobrze
                    UserList.getInstance().setUserList(data[USER_LOGIN], user);
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
    public static void checkTheFileUserExist() throws IOException {
        File file = new File("C:\\Users\\marcin\\IdeaProjects\\auction3\\UserList2.csv");
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
    }
}

