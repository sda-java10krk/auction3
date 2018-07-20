public class CategoryDisplay {

    public static void main(String[] args) {
        Category c0 = new Category("Elektronika");
        Category c1 = new Category("Komputery");
        Category c2 = new Category("Laptopy");
        Category c3 = new Category("Stacjonarne");
        c0.addSubcategory(c1);
        c1.addSubcategory(c2);
        c1.addSubcategory(c3);

        c0.print(2);
    }
}
