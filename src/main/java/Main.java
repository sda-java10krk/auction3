import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj! Co chcesz zrobić?");
        System.out.println("1.Logowanie");
        System.out.println("2.Rejestracja");
        System.out.println("3.Wyjście");

        
        n=scanner.nextInt();

        switch(n){
            case(1):{
                System.out.println("Podaj login: ");
                String login = scanner.next();
                System.out.println("Podaj haslo: " );
                String password = scanner.next();

                UserControllers userControllers = new UserControllers();
//                userControllers.userIsPresent(login,password);
            }
            case(2):{
            }

        }
    }
}
