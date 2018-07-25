import Exceptions.*;
import Models.Auction;
import Models.Category;
import Models.Offer;
import Models.User;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AuctionTest {


    Exception ex;
    User user = new User("Kapaika","Passsword");

    public AuctionTest() throws TooShortPasswordException {
    }

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

        assertNull(ex);
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

        assertNull(ex);
    }

    @Test(expected = TooLowPriceException.class)
    public void testThrowTooLowPriceExceptionIfStartingPriceIsNegative() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Auction auction = new Auction(user,"Tytul","Opis",BigDecimal.valueOf(0),new Category("Elektronika"));
    }

    @Test
    public void testReturnEqualsIfStartingPriceIsNotNegative() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        try{
            Auction auction = new Auction(user,"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        }catch(TooLowPriceException e){
            ex=e;
        }

        assertNull(ex);
    }

    @Test(expected = SubcategoryPresentException.class)
    public void testThrowSubcategoryExceptionIfCategoryHasSubcategory() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        Category category = new Category("Elektronika");
        Category category2 = new Category("Komputery");
        category.addSubcategory(category2);
        Auction auction = new Auction(user,"Tytul","Opis",BigDecimal.valueOf(2000),category);
    }

    @Test
    public void testReturnEqualsIfCategoryDoNotHasSubcategory() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        Category category = new Category("Elektronika");
        Category category2 = new Category("Komputery");
        category.addSubcategory(category2);
        try {
            Auction auction = new Auction(user,"Tytul", "Opis", BigDecimal.valueOf(2000), category2);
        }catch(SubcategoryPresentException e){
            ex=e;
        }

        assertNull(ex);
    }

    @Test(expected = AddingOfferToOwnAuction.class)
    public void testThrowAddingOfferToOwnAuctionIfUserAddingOfferToOwnAuction() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, NegativeOfferPriceException {

        Auction auction = new Auction(user,"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(2000));

        auction.addOffer(offer);
    }

    @Test
    public void testReturnNullIfUserDoNotAddOfferToOwnAuction() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, TooShortPasswordException, NegativeOfferPriceException {

        Auction auction = new Auction(new User("Bartosz","aalallalal"),"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(2000));
        try {
            auction.addOffer(offer);
        }catch(AddingOfferToOwnAuction e){
            ex=e;
        }
        assertNull(ex);
    }

    @Test(expected = OfferTooLowException.class)
    public void testThrowOfferTooLowExceptionIfUserAddingTooLowOffer() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, TooShortPasswordException, NegativeOfferPriceException {


        Auction auction = new Auction(new User("Bartosz","aalallalal"),"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(2));

        auction.addOffer(offer);
    }

    @Test
    public void testReturnNullIfUserAddCorrectOffer() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, TooShortPasswordException, NegativeOfferPriceException {


        Auction auction = new Auction(new User("Bartosz","aalallalal"),"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(2000));
        try {
            auction.addOffer(offer);
        }catch(OfferTooLowException e){
            ex=e;
        }

        assertNull(ex);
    }

    @Test
    public void testReturnEqualsIfOfferAdded() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, TooShortPasswordException, NegativeOfferPriceException {

        Auction auction = new Auction(new User("Bartosz","aalallalal"),"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(200));

        auction.addOffer(offer);

        Offer currentOffer = auction.getCurrentOffer();

        assertEquals(offer,currentOffer);
    }

    @Test
    public void testReturnTrueIfThereAreLessThenThreeOffers() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, TooShortPasswordException, NegativeOfferPriceException {

        Auction auction = new Auction(new User("Bartosz","aalallalal"),"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(200));
        Offer offer1 = new Offer(user,BigDecimal.valueOf(300));

        auction.addOffer(offer);
        boolean result = auction.addOffer(offer1);

        assertTrue(result);
    }

    @Test
    public void testReturnFalseIfWeOfferedMoreThanThreeOffers() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException, AddingOfferToOwnAuction, OfferTooLowException, TooShortPasswordException, NegativeOfferPriceException {

        Auction auction = new Auction(new User("Bartosz","aalallalal"),"dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        Offer offer = new Offer(user,BigDecimal.valueOf(200));
        Offer offer1 = new Offer(user,BigDecimal.valueOf(300));
        Offer offer2 = new Offer(user,BigDecimal.valueOf(400));
        Offer offer3 = new Offer(user,BigDecimal.valueOf(500));

        auction.addOffer(offer);
        auction.addOffer(offer1);
        auction.addOffer(offer2);
        boolean result = auction.addOffer(offer3);

        assertFalse(result);

    }



}
