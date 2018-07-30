import Models.Auction;
import Models.AuctionsDatabase;
import Models.Category;
import Models.User;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AuctionDatabseTest {

    @Test
    public void testShouldCollect() throws Exception{
        User user = new User("Kapaika","Passsword");
        Auction auction = new Auction(user,"dddd","fdsfsd",new BigDecimal(2000),new Category("Elektronika"));
        AuctionsDatabase.getInstance().addCurrentAuction(auction);

        Auction auction2 = AuctionsDatabase.getInstance().getCurrentAuctions().get(0);

        assertEquals(auction,auction2);
    }
}
