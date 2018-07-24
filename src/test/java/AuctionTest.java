import Exceptions.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AuctionTest {


    Exception ex;
    User user = new User("Kapaika","Passsword");

    @Test(expected = EmptyTitleException.class)
    public void testThrowEmptyTitleExceptionIfTitleIsEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Auction auction = new Auction(user,"","asdasdascas",new BigDecimal(2.0),new Category("Elektronika"));
    }

    @Test
    public void testReturnEqualsIfTitleIsNotEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        try{
            Auction auction = new Auction(user,"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        }catch(EmptyTitleException e){
            ex=e;
        }

        assertEquals(null,ex);
    }

    @Test(expected = EmptyDescriptionException.class)
    public void testThrowEmptyDescriptionExceptionIfTitleIsEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Auction auction = new Auction(user,"dddd","",new BigDecimal(2000),new Category("Elektronika"));
    }

    @Test
    public void testReturnEqualsIfDescriptionIsNotEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        try{
            Auction auction = new Auction(user,"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        }catch(EmptyDescriptionException e){
            ex=e;
        }

        assertEquals(null,ex);
    }

    @Test(expected = TooLowPriceException.class)
    public void testThrowTooLowPriceExceptionIfStartingPriceIsNegative() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Auction auction = new Auction(user,"Tytul","Opis",BigDecimal.valueOf(-1),new Category("Elektronika"));
    }

    @Test
    public void testReturnEqualsIfStartingPriceIsNotNegative() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        try{
            Auction auction = new Auction(user,"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        }catch(TooLowPriceException e){
            ex=e;
        }

        assertEquals(null,ex);
    }

    @Test(expected = SubcategoryPresentException.class)
    public void testThrowSubcategoryExceptionIfCategoryHasSubcategory() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Category category = new Category("Elektronika");
        Category category2 = new Category("Komputery");
        category.addSubcategory(category2);
        Auction auction = new Auction(user,"Tytul","Opis",BigDecimal.valueOf(2000),category);
    }

    @Test
    public void testReturnEqualsIfCategoryDoNotHasSubcategory() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Category category = new Category("Elektronika");
        Category category2 = new Category("Komputery");
        category.addSubcategory(category2);
        try {
            Auction auction = new Auction(user,"Tytul", "Opis", BigDecimal.valueOf(2000), category2);
        }catch(SubcategoryPresentException e){
            ex=e;
        }

        assertEquals(null,ex);
    }

    @Test(expected = AddingOfferToOwnAuction.class)
    public void testThrowAddingOfferToOwnAuctionIfUserAddingOfferToOwnAuction() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException {

        Auction auction = new Auction(user,"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offers offer = new Offers(user,BigDecimal.valueOf(2000));

        auction.addingOffer(offer);
    }

}
