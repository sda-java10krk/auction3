import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {


    public void saveUserToList (Map<String, User> map1) {

        String fileName1 = "UserList.txt";
        try {
            FileOutputStream fileWriter1 = new FileOutputStream(fileName1);
            ObjectOutputStream writer1 = new ObjectOutputStream(fileWriter1);
            {
                writer1.writeObject(map1);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName1);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName1);
        }
    }



    public void saveOffersForAuction (Map<Auction, List > map2) {

        String fileName2 = "AuctionAndOffersList.txt";
        try {
            FileOutputStream fileWriter2 = new FileOutputStream(fileName2);
            ObjectOutputStream writer2 = new ObjectOutputStream(fileWriter2);
            {
                writer2.writeObject(map2);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName2);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName2);
        }
    }

    public HashMap<String, User> readUserFromList () {

        String fileName1 = "UserList.txt";
        try {
            FileInputStream fileReader1 = new FileInputStream(fileName1);
            ObjectInputStream reader1 = new ObjectInputStream(fileReader1);
            {
                return (HashMap<String, User >) reader1.readObject();
            }
        } catch (FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku " + fileName1);
        } catch (IOException e){
            System.err.println("Błąd podczas odczytu danych z pliku " + fileName1);
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
        }
        return null ;
    }


    public HashMap<String, List> readAuctionToOffers () {

        String fileName2 = "AuctionsList.txt";
        try {
            FileInputStream fileReader1 = new FileInputStream(fileName2);
            ObjectInputStream reader1 = new ObjectInputStream(fileReader1);
            {
                return (HashMap<String, List >) reader1.readObject();
            }
        } catch (FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku " + fileName2);
        } catch (IOException e){
            System.err.println("Błąd podczas odczytu danych z pliku " + fileName2);
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
        }
        return null ;
    }


    }






//    String fileName2 = "Auctionstxt";
//    String fileName3 = "Offers.txt";
//    String fileName4 = "Users.txt";