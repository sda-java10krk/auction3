import Helpers.AuctionID;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IDTests {

    @Test
    public void IdTest(){
        int one = AuctionID.getInstance().getId();
        int two = AuctionID.getInstance().getId();
        assertEquals(one+1,two);
    }
}
