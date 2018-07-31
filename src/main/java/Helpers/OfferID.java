package Helpers;

public class OfferID {

    private static OfferID instance;
    private static int id=0;

    public static OfferID getInstance(){
        if (instance == null){
            instance = new OfferID();
        }
        return instance;
    }
    public int getId(){

        id++;
        return id;

    }
}
