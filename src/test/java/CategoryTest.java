import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CategoryTest {
    @Test
    public void testReturnTrueIfSubcategoryExists(){
        Category c0 = new Category("Elektronika");
        Category c1 = new Category("Komputery");
        Category c2 = new Category("Laptopy");
        Category c3 = new Category("Stacjonarne");
        c0.addSubcategory(c1);
        c1.addSubcategory(c2);
        c1.addSubcategory(c3);

        boolean checker = c0.isSubcategoryPresent(c0);

        assertTrue(checker);
    }
}
