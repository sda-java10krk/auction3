
import java.util.HashMap;
import java.util.Map;

public class UserList {

    private static UserList Instance;
    private Map<String, User> userList = new HashMap<>();

    public UserList() {
    }

    public void createUser (String login, String password) throws IllegalArgumentException {
        userList.put(login, new User(login,password));
    }

    public Map<String, User> getUserList() {
        return userList;
    }

    public void setUserList(Map<String,User> userList) {
        this.userList = userList;
    }

    public UserList(Map<String,User> userList) {
        this.userList = userList;
    }

    public static UserList getInstance() {
        if(Instance == null){
            Instance = new UserList();
        }
        return Instance;
    }
}
