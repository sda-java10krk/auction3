import java.io.*;

public class FileManager {



    public void saveUserToList (User user) {

        String fileName1 = "UserList.txt";
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

    public void saveOffersForAuction (Auction auction) {

        String fileName3 = "OffersList.txt";
        try {
            FileOutputStream fileReader3 = new FileOutputStream(fileName3);
            ObjectOutputStream reader3 = new ObjectOutputStream(fileReader3);
            {
                reader3.writeObject(auction);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName3);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName3);
        }
    }



    }






//    String fileName2 = "Auctionstxt";
//    String fileName3 = "Offers.txt";
//    String fileName4 = "Users.txt";