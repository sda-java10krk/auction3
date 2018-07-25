import Models.Auction;
import Models.Offer;
import Models.User;

import java.io.*;

public class FileManager {



    public void saveUserToList (User user) {

        String fileName1 = "Controllers.UserList.txt";
        try {
            FileOutputStream fileReader1 = new FileOutputStream(fileName1);
            ObjectOutputStream reader1 = new ObjectOutputStream(fileReader1);
            {
                reader1.writeObject(user);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName1);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName1);
        }
    }

    public void saveAuctions (Auction auction) {

        String fileName2 = "AuctionList.txt";
        try {
            FileOutputStream fileReader2 = new FileOutputStream(fileName2);
            ObjectOutputStream reader2 = new ObjectOutputStream(fileReader2);
            {
                reader2.writeObject(auction);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName2);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName2);
        }
    }

    public void saveOffersForAuction (Offer offers) {

        String fileName3 = "OffersList.txt";
        try {
            FileOutputStream fileReader3 = new FileOutputStream(fileName3);
            ObjectOutputStream reader3 = new ObjectOutputStream(fileReader3);
            {

                reader3.writeObject(offers);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName3);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName3);
        }
    }


    public void readUserFromList (User user) {

        String fileName1 = "Controllers.UserList.txt";
        try {
            FileInputStream fis = new FileInputStream(fileName1);
            ObjectInputStream  writer1 = new ObjectInputStream(fis);
            {
                writer1.readObject();
            }
        } catch (FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku " + fileName1);
        } catch (IOException e){
            System.err.println("Błąd podczas odczytu danych z pliku " + fileName1);
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
        }
    }


    }






//    String fileName2 = "Auctionstxt";
//    String fileName3 = "Models.Offers.txt";
//    String fileName4 = "Users.txt";