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

        public void createUser (String login, String password) throws IllegalArgumentException, TooShortPasswordException {
            userList.put(login, new User(login, password));
        }

        public Map<String, User> getUserList () {
            return userList;
        }


    public UserList() {
        this.userList= new HashMap<>();
    }

    private void setUserList(String login, User user) {
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

    public User findUser( String login, String password)throws UserNotExistInBaseException {
        if(this.userList.containsKey(login)&& this.userList.get(login).getPassword().equals(password))
            throw new UserNotExistInBaseException();

        else {
            return this.userList.get(login);
        }
    }

    public void addUser(User user) throws UserAlreadyInTheBaseException {
        if(this.userList.containsKey(user.login)) {
            throw new UserAlreadyInTheBaseException();
        }
        this.userList.put(user.login, user);
    }

}

