package Views;

import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Models.Category;

public class CategoryDisplay {


    public static void initializeCategories() throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {

            Category FirstCategory = new Category("Kategorie");


            Category categoryTree = new Category(null);

            Category c0 = new Category("Elektronika");
            Category c7 = new Category("Motozycja");

            Category c1 = new Category("Komputery");
            Category c2 = new Category("Laptopy");
            Category c3 = new Category("Stacjonarne");
            Category c4 = new Category("Telefony");
            Category c5 = new Category("IPhone");
            Category c6 = new Category("Android");


            Category c8 = new Category("Samochody");
            Category c9 = new Category("Osobowe");
            Category c10 = new Category("Ciężarówka");
            Category c11 = new Category("Skutery");

            FirstCategory.addSubcategory(c0);
            FirstCategory.addSubcategory(c7);

            c0.addSubcategory(c1); //elektronika -> Komputery
            c0.addSubcategory(c4); // elektronika -> Telefony



            c0.addSubcategory(c1); //elektronika -> Komputery
            c0.addSubcategory(c4); // elektronika -> Telefony

            c7.addSubcategory(c8); // Motoryzacja ->  Samochody
            c7.addSubcategory(c11); // Motoryzacja ->  Skutery


            c1.addSubcategory(c2);  // Komputery -> Laptopy
            c1.addSubcategory(c3);  // Komputery ->  Stacjonarne

            c4.addSubcategory(c5);  // Telefony -> IPhone
            c4.addSubcategory(c6);  // Telefony ->  Android

            c0.print(0);


            c8.addSubcategory(c9);  // Samochody -> Osobowe
            c8.addSubcategory(c10);  // Samochody ->  Ciężarówka


            FirstCategory.print(2);
        }


    }


// ZEBY NIE DAŁO SIE sie dodac sukbategorii do miejsca gdzie jest juz akcja
// metoda ktora dodaje auckej do subkategorii sprawdzjac wczesniej czy nie ma zadnej sukbategirii

// funkcja ktora wyswietla aukcje z danej kategorii
// czyli jak wpisze android to pokaze auckej androiga a jak wpisze telefony to wpisze wszystkie auckej telefonów ze wzgledu na kategori