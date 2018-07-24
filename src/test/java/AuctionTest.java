import Exceptions.EmptyDescriptionException;
import Exceptions.EmptyTitleException;
import Exceptions.SubcategoryPresentException;
import Exceptions.TooLowPriceException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AuctionTest {


    Exception ex;

    @Test(expected = EmptyTitleException.class)
    public void testThrowEmptyTitleExceptionIfTitleIsEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Auction auction = new Auction("","asdasdascas",new BigDecimal(2.0),new Category("Elektronika"));
    }

    @Test
    public void testReturnEqualsIfTitleIsNotEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        try{
            Auction auction = new Auction("dsadsa","asdasdascas", BigDecimal.valueOf(20),new Category("Elektronika"));
        }catch(EmptyTitleException e){
            ex=e;
        }

        assertEquals(null,ex);
    }

    @Test(expected = EmptyDescriptionException.class)
    public void testThrowEmptyDescriptionExceptionIfTitleIsEmpty() throws EmptyDescriptionException, EmptyTitleException, TooLowPriceException, SubcategoryPresentException {
        Auction auction = new Auction("dddd","",new BigDecimal(2000),new Category("Elektronika"));
    }

}
