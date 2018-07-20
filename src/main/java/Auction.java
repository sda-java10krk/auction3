import Exceptions.SubcategoryPresentException;

public class Auction {
    String title;
    String description;
    Long startingPrice;
    Category category;

    public Auction(String title, String description, Long startingPrice, Category category) throws SubcategoryPresentException {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        if(category.isSubcategoryPresent(category.toString())){
            throw new SubcategoryPresentException();
        }else{
            this.category = category;
        }
    }

    public void currentOffer(){
        
    }




}
/*
Każdy użytkownik może wystawić aukcję. Aukcja ma: tytuł, opis, cenę początkową, kategorię.
Każde z tych pól może mieć wartość, która się powtarza, tj. np. mogą być w systemie dwie aukcje "Opel Astra" za 1000zł tego samego użytkownika.
 */