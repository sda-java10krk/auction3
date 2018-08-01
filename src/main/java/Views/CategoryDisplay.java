package Views;

import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Models.CategoriesDatabase;
import Models.Category;

public class CategoryDisplay {




    public static void printCategoryTree() throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        CategoriesDatabase.getInstance().getRootCategory().print(0);

    }

    public static void askAboutCategory() {
        System.out.println("Podaj kategorie ogólną lub szczegółową, aby zobaczyć aukcje");
    }
}


// ZEBY NIE DAŁO SIE sie dodac sukbategorii do miejsca gdzie jest juz akcja
// metoda ktora dodaje auckej do subkategorii sprawdzjac wczesniej czy nie ma zadnej sukbategirii

// funkcja ktora wyswietla aukcje z danej kategorii
// czyli jak wpisze android to pokaze auckej androiga a jak wpisze telefony to wpisze wszystkie auckej telefonów ze wzgledu na kategori