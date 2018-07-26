import Exceptions.*;
import Models.Category;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CategoryTest {
    @Test
    public void testReturnTrueIfSubcategoryExists() throws Exception {
        Category c0 = new Category("Elektronika");
        Category c1 = new Category("Komputery");
        Category c2 = new Category("Laptopy");
        Category c3 = new Category("Stacjonarne");
        c0.addSubcategory(c1);
        c1.addSubcategory(c2);
        c1.addSubcategory(c3);

        boolean checker = c0.isSubcategoryPresent();

        assertTrue(checker);
    }

    @Test
    public void testReturnFalseIfSubcategoryDoesNotExists() throws Exception {
        Category c0 = new Category("Elektronika");
        Category c1 = new Category("Komputery");
        Category c2 = new Category("Laptopy");
        Category c3 = new Category("Stacjonarne");
        c0.addSubcategory(c1);
        c1.addSubcategory(c2);
        c1.addSubcategory(c3);

        boolean checker = c3.isSubcategoryPresent();

        assertFalse(checker);
    }

//    @Test(expected = AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException.class)
//    public void testThrowAddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException() throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException, SubcategoryPresentException, EmptyTitleException, EmptyDescriptionException, TooLowPriceException {
//        Models.Category c0 = new Models.Category("Elektronika");
//        Models.Category c1 = new Models.Category("Komputery");
//        Models.Category c2 = new Models.Category("Laptopy");
//        Models.Category c3 = new Models.Category("Stacjonarne");
//        Models.Auction auction = new Models.Auction(new Models.User("Bartosz","ssssss"),"Tytul","Opis",BigDecimal.valueOf(2000),c2);
//        c0.addSubcategory(c1);
//        c1.addSubcategory(c2);
//        c2.addAuction(auction);
//        c2.addSubcategory(c3);
//    }

}
