package Models;

import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Exceptions.SubcategoryPresentException;

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


    public void addSubcategory(Category category) throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        if(!isSubcategoryPresent() && !this.subcategories.isEmpty()){
            throw new AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException();
        }else{
            subcategories.add(category);
        }

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

    public Set<Auction> getAuction() {
        return auction;
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        if(name == null){
            name = "Kategorie";
        }
         return "";
    }
}
