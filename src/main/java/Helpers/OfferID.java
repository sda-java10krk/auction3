package Helpers;

public class OfferID {

    private static OfferID instance;
    private Integer id=0;

    public static OfferID getInstance(){
        if (instance == null){
            instance = new OfferID();
        }
        return instance;
    }
    public Integer getId(){

        id++;
        return id;

    }
}
