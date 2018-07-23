
public class Offers {

    User user;
    Long price;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Offers(User user, Long price) {
        this.user = user;
        this.price = price;
    }
}
