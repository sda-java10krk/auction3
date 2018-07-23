import java.io.*;

public class FileManager {

    public void saveUserToList (User user) {

        String fileName1 = "UserList.txt";
            try {
                FileOutputStream fileReader = new FileOutputStream(fileName1);
                ObjectOutputStream reader1 = new ObjectOutputStream(fileReader);
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



    }






//    String fileName2 = "Auctionstxt";
//    String fileName3 = "Offers.txt";
//    String fileName4 = "Users.txt";