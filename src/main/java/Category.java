import java.util.HashSet;
import java.util.Set;

public class Category {

    //private Set<Product> products;
    private Set<Category> subcategories;
    private String name;

    public Category(String name) {
        this.name = name;
    //    this.products = new HashSet<>();
        this.subcategories = new HashSet<Category>();
    }

   // public void addProduct(Product product) {
     //   this.products.add(product);
    //}

    public void addSubcategory(Category category) {
        this.subcategories.add(category);
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public String getName() {
        return name;
    }



    public void print(int level){

        for(int i =0 ; i<level ; i++){
            System.out.print("-");
        }
        System.out.println(this.name);

        for(Category subcategories : this.subcategories){
                subcategories.print(level+1);

        }
    }

    public boolean isSubcategoryPresent(String name){

            for (Category subcategories : this.subcategories) {

                if(subcategories.getName().equals(name)){
                    return true;
                }else {
                    subcategories.isSubcategoryPresent(name);
                    if(subcategories.isSubcategoryPresent(name)){
                        return true;
                    }
                }

            }

            return false;
    }



    @Override
    public String toString() {
        if(name == null){
            name = "Kategorie";
        }
         return "";
    }
}
