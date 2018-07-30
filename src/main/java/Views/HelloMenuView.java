package Views;

public class HelloMenuView {

    public static void helloView(){
        System.out.println("Witaj! Co chcesz zrobić?");
        System.out.println("1.Logowanie");
        System.out.println("2.Rejestracja");
        System.out.println("3.Wyjście");
    }

    public static void askForLogin(){
        System.out.println("Podaj login: ");
    }

    public static void askForPassword(){
        System.out.println("Podaj hasło: ");
    }

    public static void RegisterConfirmedInformation(){
        System.out.println("Zostałeś zarejestrowany!");
    }

    public static void WrongAnwser(){
        System.out.println("Zła odpowiedź!");
    }
}
