package Controllers;

import Exceptions.TooShortPasswordException;
import Models.User;

import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;

import java.util.HashMap;
import java.util.Map;

public class UserList {

    private static UserList instance;
    private Map<String, User> userList = new HashMap<>();


    public UserList() {
        this.userList= new HashMap<>();
    }

    private void setUserList(String login, User user) {
    }
    public void setUserList(Map<String,User> userList) {
        this.userList = userList;
    }
    public UserList(Map<String,User> userList) {
        this.userList = userList;
    }

        public static UserList getInstance() {
        if(instance == null){
            instance = new UserList();
        }
        return instance;
    }
    public boolean findUser( String login, String password)throws UserNotExistInBaseException {
        if(this.userList.containsKey(login)&& this.userList.get(login).getPassword().equals(password)){
            throw new UserNotExistInBaseException();
        }
        else {
            this.userList.get(login);
        }
        return true;
    }

    public boolean registerUser( String login, String password) throws UserAlreadyInTheBaseException, TooShortPasswordException {
        if(this.userList.containsKey(login)){
            throw new UserAlreadyInTheBaseException();
        }
        else {
            this.userList.put(login,new User(login,password));
        }
        return true;
    }


}
