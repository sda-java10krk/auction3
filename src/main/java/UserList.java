
import Exceptions.TooShortPassword;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class UserList {

    private static UserList instance;
    private Map<String, User> userList = new HashMap<>();


    public Map<String, User> getUserList() {
        return userList;
    }

    public UserList() {
    }

    public void createUser (String login, String password) {
        userList.put(login,new User(login, password));
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
    public User findUser( String login, String password) {
        if(this.userList.containsKey(login)&& this.userList.get(login).getPassword().equals(password));
        return this.userList.get(login);
    }

}
