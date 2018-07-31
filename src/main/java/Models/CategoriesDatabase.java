package Models;

import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;


public class CategoriesDatabase {
    private static CategoriesDatabase instance;

    private Category rootCategory;
    private Category bottom1;
    private Category bottom2;
    private Category bottom3;
    private Category bottom4;
    private Category bottom5;
    private Category bottom6;
    private Category bottom7;

    public static CategoriesDatabase getInstance(){
        if (instance == null){
            instance = new CategoriesDatabase();
        }
        return instance;
    }


    public CategoriesDatabase() {

        Category FirstCategory = new Category("Kategorie");

        Category c0 = new Category("Elektronika");
        Category c7 = new Category("Motozycja");

        Category c1 = new Category("Komputery");
        Category c2 = new Category("Laptopy");
        Category c3 = new Category("Stacjonarne");
        Category c4 = new Category("Telefony");
        Category c5 = new Category("IPhone");
        Category c6 = new Category("Android");


        Category c8 = new Category("Samochody");
        Category c9 = new Category("Osobowe");
        Category c10 = new Category("Ciężarówka");
        Category c11 = new Category("Skutery");

        try {
            FirstCategory.addSubcategory(c0);
            FirstCategory.addSubcategory(c7);

            c0.addSubcategory(c1); //elektronika -> Komputery
            c0.addSubcategory(c4); // elektronika -> Telefony


            c0.addSubcategory(c1); //elektronika -> Komputery
            c0.addSubcategory(c4); // elektronika -> Telefony

            c7.addSubcategory(c8); // Motoryzacja ->  Samochody
            c7.addSubcategory(c11); // Motoryzacja ->  Skutery


            c1.addSubcategory(c2);  // Komputery -> Laptopy
            c1.addSubcategory(c3);  // Komputery ->  Stacjonarne

            c4.addSubcategory(c5);  // Telefony -> IPhone
            c4.addSubcategory(c6);  // Telefony ->  Android

            c8.addSubcategory(c9);  // Samochody -> Osobowe
            c8.addSubcategory(c10);  // Samochody ->  Ciężarówka
        } catch (AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException e) {
            // will never happen
            e.printStackTrace();
        }

        this.rootCategory = FirstCategory;
        this.bottom1 = c2;
        this.bottom2 = c3;
        this.bottom3 = c5;
        this.bottom4 = c6;
        this.bottom5 = c9;
        this.bottom6 = c10;
        this.bottom7 = c11;
    }

//    public Category findCategoryByIdString(String name){
//
//        return findCategoryById(name,rootCategory);
//
//    }
//
//    public Category findCategoryById(String name, Category category){
//
//        if(category.getName().equals(name)){
//            return category;
//        }
//
//        for(Category category1: category.getSubcategories()){
//            return findCategoryById(name,category1);
//        }
//        return null;
//    }


    public Category findCategoryByString(String name){

        if(this.bottom1.getName().equals(name)){
            return this.bottom1;
        }
        if(this.bottom2.getName().equals(name)){
            return this.bottom2;
        }
        if(this.bottom3.getName().equals(name)){
            return this.bottom3;
        }
        if(this.bottom4.getName().equals(name)){
            return this.bottom4;
        }
        if(this.bottom5.getName().equals(name)){
            return this.bottom5;
        }
        if(this.bottom6.getName().equals(name)){
            return this.bottom6;
        }if(this.bottom7.getName().equals(name)){
            return this.bottom7;
        }
        return null;
    }


    public Category getRootCategory() {
        return rootCategory;
    }
}
