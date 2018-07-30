package Models;

import Exceptions.BadChooseToCategory;


import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Exceptions.SubcategoryDoNotExist;
import Exceptions.SubcategoryPresentException;
import Models.Auction;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Category implements Serializable {

    public static final int PRINT_LEVEL_NEEDED_FOR_A_METDOD_PRINT_AUCTION_TO_SELECT_CATEGORY = 0;

    private Set<Auction> auction;
    private Set<Category> subcategories;
    private String name;

    //TODO
    // private static Category instance;

//    public Category() {
//    }

//    public static Category getInstance() {
//        if(instance == null){
//            instance = new Category();
//        }
//        return instance;
//    }

    public Category(String name) {
        this.name = name;
        this.subcategories = new HashSet<Category>();
        this.auction = new HashSet<Auction>();
    }


    public void addAuction(Auction auction) throws SubcategoryPresentException {
        if (isSubcategoryPresent()) {
            throw new SubcategoryPresentException();
        } else {
            this.auction.add(auction);
        }
    }


    public void removingAuction(Auction auction) {
        this.auction.remove(auction);
    }


    public void addSubcategory(Category category) throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        if (!isSubcategoryPresent() && !this.subcategories.isEmpty()) {
            throw new AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException();
        }else{

            this.subcategories.add(category);
        }
    }


    public String getName() {
        return name;
    }


    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(this.name);

        for (Category subcategories : this.subcategories) {
            subcategories.print(level + 1);
        }
    }

    //TODO
    public void findCategoryAndShowAuctions(String category) throws SubcategoryDoNotExist {
        int level = PRINT_LEVEL_NEEDED_FOR_A_METDOD_PRINT_AUCTION_TO_SELECT_CATEGORY;

        if(this.subcategories.contains(category))

        if (!isSubcategoryPresent()) {
            throw new SubcategoryDoNotExist();
        } else {

            System.out.println(this.name);

            for (Category subcategories : this.subcategories) {
                subcategories.print(level + 1);
            }
            if (subcategories.isEmpty()) {
                System.out.println("auctions");
            }
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

    public void getNameOfAuction(){
        System.out.println("SIEMANO");
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        if (name == null) {
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
