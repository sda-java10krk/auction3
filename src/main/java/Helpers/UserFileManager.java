package Helpers;

import Models.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class UserFileManager {

    private static UserFileManager instance;

    public UserFileManager() {

    }

    private static UserFileManager getInstance() {
        if (instance == null) {
            instance = new UserFileManager();
        }
        return instance;
    }

    private static final String COMMA_SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String PARAMETRS = "login,password";


    // public void writeCsvFile(String filename, User user) {
    public void writeCsvFile(String filename, Map<String, User> map) {
        FileWriter fileWriter = null;

        try {
            for (User user : map.values()) {
                fileWriter = new FileWriter(filename);
                fileWriter.append(PARAMETRS.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(user.getLogin());
                fileWriter.append(COMMA_SEPARATOR);
                  fileWriter.append(user.getPassword());
                fileWriter.append(COMMA_SEPARATOR);
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
}
