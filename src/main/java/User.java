import java.util.*;

public class User {

    String login;
    String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    List<User> userList = new ArrayList<User>();

    public User createUser() throws IllegalArgumentException  {

        System.out.println("Podaj swoj login: ");
        Scanner scan = new Scanner(System.in);
        login= scan.next();
        for(int i = 0; i<= userList.size()-1;i++){
            if(userList.get(i).login.equals(login)){
                throw new IllegalArgumentException();
            }
        }
            System.out.println("Podaj haslo do konta:");
            password = scan.next();
            if (password.length() < 5) {
                throw new IllegalArgumentException();
            }
            else {
                User user = new User();
                userList.add(user);
                return user;
            }
    }



    public void makeAnOffer(long offer){

    }
}
