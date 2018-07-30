package Controllers;

import Exceptions.TooShortPasswordException;
import Helpers.SaveReadManager;
import Helpers.UserFileManager;
import Models.User;

import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserList {

    private static UserList instance;

    private Map<String, User> userList = new HashMap<>();
    private UserFileManager userFileManager = new UserFileManager();
    //private SaveReadManager saveReadManager = new SaveReadManager();


        public Map<String, User> getUserList () {
            return userList;
        }


    public UserList() {
        this.userList= new HashMap<>();
    }

    public void setUserList(String login, User user) {
    }

        public void setUserList (Map < String, User > userList){
            this.userList = userList;
        }

    public UserList(Map < String, User > userList) {
            this.userList = userList;
        }

        public static UserList getInstance() {
        if(instance == null){
            instance = new UserList();
        }
        return instance;
    }

    public boolean findUser(String login, String password) throws UserNotExistInBaseException, TooShortPasswordException {
        if(this.userList.containsKey(login) && this.userList.get(login).getPassword().equals(password)){
            this.userList.get(login);
        }
        else {
            throw new UserNotExistInBaseException();

        }
        return true;
    }

    public boolean registerUser(String login, String password) throws UserAlreadyInTheBaseException, TooShortPasswordException, IOException {
        if(this.userList.containsKey(login)){
            throw new UserAlreadyInTheBaseException();
        }
        else {
            User user = new User(login,password);
            this.userList.put(login,user);
            //saveReadManager.saveUserToFile(userList);

            userFileManager.saveUserToFileCSV(userList);

        }
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList1 = (UserList) o;
        return Objects.equals(userList, userList1.userList);
    }



    @Override
    public int hashCode() {

        return Objects.hash(userList);
    }
}

