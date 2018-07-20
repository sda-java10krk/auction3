import java.util.HashSet;
import java.util.Set;

public class Category {

   // zbiór kategorii

    private Set<Category> subcategories;
    private String name;

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public String getName() {
        return name;
    }

    public Category(String name) {
        this.name = name;
        this.subcategories = new HashSet<Category>();
    }


    public void addSubcategory(Category category) {
        subcategories.add(category);
    }




             //drukuje kategorie i podkategorie
    public void print(int level){

        for(int i =0 ; i<level ; i++){
            System.out.print("-");
        }
        System.out.println(this.name);

        for(Category subcategories : this.subcategories){
                subcategories.print(level+1);

        }
    }

    // czy dana dategoria ma subtegorie czy juz jest najnizszym poziomem
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
