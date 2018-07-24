
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UserList {

    Map<User, String> userList = new HashMap<>();



        public Map addUserToMap (User user) throws IllegalArgumentException {
         if(user.password.length()< 5 ){
             throw new IllegalArgumentException();
         }
         else if (user.login.equals(userList) == true){
             throw new IllegalArgumentException();
         }
         else {
             userList.put(user, user.getLogin());
         }

        return userList;
    }

}
