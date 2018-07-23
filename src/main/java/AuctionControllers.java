import Exceptions.SubcategoryPresentException;

import java.math.BigDecimal;
import java.util.Scanner;

public class AuctionControllers {

    public Auction createAuction() throws SubcategoryPresentException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę aukcji?");
        String title = scanner.nextLine();
        System.out.println("Podaj opis?");
        String description = scanner.nextLine();
        System.out.println("Cena startowa?");
        BigDecimal startingPrice = scanner.nextBigDecimal();
        System.out.println("Kategoria?");
        String categories = scanner.nextLine();
        Category category = new Category(categories);

        Auction auction = new Auction(title,description,startingPrice,category);

        return auction;
    }
}
