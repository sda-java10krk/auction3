import Models.CategoriesDatabase;
import Models.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoriesDatabaseTest {
    @Test
    public void categoriesSearchinTest(){
        Category category = CategoriesDatabase.getInstance().findCategoryByString("Skutery");

        Category c1 = new Category("Skutery");

        assertEquals(category,c1);
    }
}
