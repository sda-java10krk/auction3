import java.util.*;

public class User {
    String login;
    String password;


    List<User> userList = new ArrayList<User>();


    public void createUser(String login, String password) throws IllegalArgumentException  {

        System.out.println("Podaj swoj login: ");
        Scanner scan = new Scanner(System.in);
        login= scan.next();
        for(int i = 0; i<= userList.size();i++){
            if(userList.get(i).login.equals(login)){
                throw new IllegalArgumentException();
            }
        }
            System.out.println("Podaj haslo:");
            password = scan.next();
            if (password.length() < 5) {
                throw new IllegalArgumentException();
            }
    }



    public void makeAnOffer(long offer){

    }
}
