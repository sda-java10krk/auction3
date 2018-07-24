
import java.math.BigDecimal;


public class Offers {


    private User user;
    private BigDecimal price;

    public Offers(User user, BigDecimal price) {
        this.user = user;
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getPrice() {
        return price;
    }


}
