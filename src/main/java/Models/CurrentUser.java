package Models;

public class CurrentUser {

    private static CurrentUser instance;
    private User user;


    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }
}
