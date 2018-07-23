import java.util.Scanner;

public class UserControllers {

    public User createUser() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj login: ");
        String login = scanner.next();
        System.out.println("Podaj haslo: " );
        String password = scanner.next();

        User user = new User(login,password);

        return user;
    }
}
