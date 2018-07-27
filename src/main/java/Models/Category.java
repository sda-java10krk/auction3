package Models;

import Exceptions.BadChooseToCategory;



import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Exceptions.SubcategoryPresentException;
import Models.Auction;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Category implements Serializable {

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

    public void addAuction(Auction auction) throws SubcategoryPresentException {
        if(isSubcategoryPresent()) {
            throw new SubcategoryPresentException();
        }else{
            this.auction.add(auction);
        }
    }



    public void removingAuction(Auction auction){
        this.auction.remove(auction);
    }

//// jaki dostep dawać użytkownikom - czy mogą robic subkategorie tylko na najnizszym poziomie czy wyzszych tez// no bo
//    // i tak robimy aukcje tylko na najnizszym poziomie wiec jak czegos by brakowało to sobie dorobi sukbategorie na najnizszym
//    public void addSubcategory(Category category) {
//        // i gdy chce dodac subkategorie to musze jako parametr przyjac 1. gdzie chce dodac subkategorie i jak sie ma nazywac
//        subcategories.add(category);
//        //utworzyc categorie "pozostałe" i wysłac wiadomosc do userów ze aucja hest w takiej kategorii
//    }

    public void addSubcategory(Category category) throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        if(!isSubcategoryPresent() && !this.subcategories.isEmpty()){
            throw new AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException();
        }else{
            subcategories.add(category);
        }
    }

    public void showEveryOffersForCategory (){

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

    public void printAuctionToSelectedCategory(int level){
        
        System.out.println(this.name);

        for(Category subcategories : this.subcategories){
            subcategories.print(level+1);
        }
        if (subcategories.isEmpty()) {
            System.out.println("jestes na dole");
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

    public Set<Auction> getAuction() {
        return auction;
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

//    public List showAuctionBasedOnCategory (Category category){
//
//
//        return List
//    }

    @Override
    public String toString() {
        if(name == null){
            name = "Kategorie";
        }
         return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(auction, category.auction) &&
                Objects.equals(subcategories, category.subcategories) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(auction, subcategories, name);
    }
}
