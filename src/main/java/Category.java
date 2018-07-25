import Exceptions.BadChooseToCategory;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private Set<Auction> auction;

    private Set<Category> subcategories;
    private String name;



    public Category(String name) {
        this.name = name;
        this.subcategories = new HashSet<Category>();
        this.auction = new HashSet<Auction>();
    }

    // ale jak chce dac uzytnownikowi mozliwosc dodania swojej kategorii to nie powinienem robic HashSet z categoriami
    // nie rozumiem potencjalnie nieskonczeonego zagłebienia - czy to chodzi w dół czy w boki dla tego schematu co juz mamy
    // bo dla mnie nie ma sensu isc w dół jak robimy jedną odnoge

    public void addAuction(Auction auction) {
        this.auction.add(auction);
    }


    public void addAuction2(Auction auction) throws BadChooseToCategory{
        if(isSubcategoryPresent()==true){
            throw new BadChooseToCategory();
        }
        this.auction.add(auction);

    }


    public void removingAuction(Auction auction){
        this.auction.remove(auction);
    }

// jaki dostep dawać użytkownikom - czy mogą robic subkategorie tylko na najnizszym poziomie czy wyzszych tez// no bo
    // i tak robimy aukcje tylko na najnizszym poziomie wiec jak czegos by brakowało to sobie dorobi sukbategorie na najnizszym
    public void addSubcategory(Category category) {
        // i gdy chce dodac subkategorie to musze jako parametr przyjac 1. gdzie chce dodac subkategorie i jak sie ma nazywac
        subcategories.add(category);
        //utworzyc categorie "pozostałe" i wysłac wiadomosc do userów ze aucja hest w takiej kategorii
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
