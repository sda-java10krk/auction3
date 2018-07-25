import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CategoryTest {
    @Test
    public void testReturnTrueIfSubcategoryExists() throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
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
    public void testReturnFalseIfSubcategoryDoesNotExists() throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
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
}
