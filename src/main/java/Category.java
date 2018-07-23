import java.util.HashSet;
import java.util.Set;

public class Category {

   // zbiór kategorii

    private Set<Category> subcategories;
    public Set<Category> getSubcategories() {
        return subcategories;
    }
    private String name;

    public Category(String name) {
        this.name = name;
        this.auction = new HashSet<Auction>();
        this.subcategories = new HashSet<Category>();
    }


    private Set<Auction> auction;


    public void addAuction(Auction auction) {
        this.auction.add(auction);
    }


    public void addSubcategory(Category category) {
        subcategories.add(category);
    }

    public String getName() {
        return name;
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

    public boolean isSubcategoryPresent(Category category) {


        for (Category subcategories : this.subcategories) {

            if (subcategories != null) {
                return true;
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
