public class Auction {
    String title;
    String description;
    Long startingPrice;
    Category category;

    public Auction(String title, String description, Long startingPrice, Category category) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.category = category;
    }
}
/*
Każdy użytkownik może wystawić aukcję. Aukcja ma: tytuł, opis, cenę początkową, kategorię.
Każde z tych pól może mieć wartość, która się powtarza, tj. np. mogą być w systemie dwie aukcje "Opel Astra" za 1000zł tego samego użytkownika.
 */