import java.util.HashSet;
import java.util.Set;

public class Category {

    private Set<Auction> auction;
    private Set<Category> subcategories;
    private String name;


    public Category(String name) {
        this.name = name;
        this.auction = new HashSet<>();
        this.subcategories = new HashSet<>();
    }

    public void addAuction(Auction auction) {
        this.auction.add(auction);
    }

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

    public boolean isSubcategoryPresent() {

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
