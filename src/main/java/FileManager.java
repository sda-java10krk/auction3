import java.io.*;

public class FileManager {


    public void saveUserToList (String user) {

        String fileName1 = "UserList.txt";
        try {
            FileOutputStream fileWriter1 = new FileOutputStream(fileName1);
            ObjectOutputStream writer1 = new ObjectOutputStream(fileWriter1);
            {
                writer1.writeObject(user);
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
            FileOutputStream fileWriter2 = new FileOutputStream(fileName2);
            ObjectOutputStream writer2 = new ObjectOutputStream(fileWriter2);
            {
                writer2.writeObject(auction);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName2);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName2);
        }
    }

    public void saveOffersForAuction (Offers offers) {

        String fileName3 = "OffersList.txt";
        try {
            FileOutputStream fileWriter3 = new FileOutputStream(fileName3);
            ObjectOutputStream writer3 = new ObjectOutputStream(fileWriter3);
            {

                writer3.writeObject(offers);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName3);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName3);
        }
    }


    public User readUserFromList () {

        String fileName1 = "UserList.txt";
        try {
            FileInputStream fileReader1 = new FileInputStream(fileName1);
            ObjectInputStream reader1 = new ObjectInputStream(fileReader1);
            {
                return (User) reader1.readObject();
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


    }






//    String fileName2 = "Auctionstxt";
//    String fileName3 = "Offers.txt";
//    String fileName4 = "Users.txt";