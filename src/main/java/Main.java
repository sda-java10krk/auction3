import Controllers.UserControllers;
import Views.CategoryDisplay;
import Views.HelloMenuView;
import Views.LoggedUserMenuView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int n=0;
        Scanner scanner = new Scanner(System.in);
        UserControllers userControllers = new UserControllers();
        HelloMenuView.helloView();
        n=scanner.nextInt();
        switch(n){
            case(1):{
                HelloMenuView.askForLogin();
                String login = scanner.next();
                HelloMenuView.askForPassword();
                String password = scanner.next();
                if(userControllers.userLogin(login,password)){
                    LoggedUserMenuView.FirstOptionsView();
                    int k=scanner.nextInt();
                    switch(k){
                        case(1):{
                            CategoryDisplay.showCategoryTree();
                        }
                        case(2):{
                            //Aukcje Wystawione przez Usera

                        }
                        case(3):{
                            //Auckje wygrane przez Usera
                        }
                    }
                }
            }
            case(2):{
                HelloMenuView.askForLogin();
                String login = scanner.next();
                HelloMenuView.askForPassword();
                String password = scanner.next();
                if(userControllers.userRegister(login,password)){
                    HelloMenuView.RegisterConfirmedInformation();
                }

            }
            case(3):{
                break;
            }

        }
    }
}
