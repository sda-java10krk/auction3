package Models;

import Exceptions.UserNotExistInBaseException;

public class CurrentUser {

    private static CurrentUser instance;
    private User user;


    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public User login(User user ){
        if(this.user == null) {
            this.user = user;
        }
        return this.user;
    }

    public User getUser()throws UserNotExistInBaseException {
        if(this.user == null){
            throw new UserNotExistInBaseException();
        }
        return user;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                '}';
    }
}
