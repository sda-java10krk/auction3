import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        System.out.println("Witaj! Co chcesz zrobić?");
        System.out.println("1.Logowanie");
        System.out.println("2.Rejestracja");
        System.out.println("3.Wyjście");
        int n=0;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();

        switch(n){
            case(1):{
                System.out.println("Podaj login: ");
                String login = scanner.next();
                System.out.println("Podaj haslo: " );
                String password = scanner.next();
            }
            case(2):{

            }
        }
    }
}
