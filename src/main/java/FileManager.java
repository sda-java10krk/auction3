import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileManager {



    public void saveUserToList (User user) {

        String fileName1 = "UserList.txt";
            try {
                FileReader fileReader = new FileReader(fileName1);
                BufferedReader reader1 = new BufferedReader(fileReader);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }






//    String fileName2 = "Auctionstxt";
//    String fileName3 = "Offers.txt";
//    String fileName4 = "Users.txt";