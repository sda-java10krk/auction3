import Controllers.UserControllers;
import Controllers.UserList;
import Models.CurrentUser;
import Models.User;
import Views.CategoryDisplay;
import Views.HelloMenuView;
import Views.LoggedUserMenuView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int n=0;
        Scanner scanner = new Scanner(System.in);
        State state = State.INIT;
        UserControllers userControllers = new UserControllers();


        while(state!=State.STOP){
            switch(state){
                case INIT:{
                    HelloMenuView.helloView();
                    String answer = scanner.next();
                    switch (answer){
                        case("1"):{
                            state = State.DURING_LOGIN;
                            break;
                        }
                        case("2"):{
                            state = State.DURING_REGISTRATION;
                            break;
                        }
                        case("3"):{
                            state = State.STOP;
                            break;
                        }
                        default:
                            HelloMenuView.WrongAnwser();
                            state = State.INIT;
                            break;
                    }
                    break;
                }
                case DURING_LOGIN:{

                    HelloMenuView.askForLogin();
                    String login = scanner.next();
                    HelloMenuView.askForPassword();
                    String password = scanner.next();
                    if(userControllers.userLogin(login,password)){
                        LoggedUserMenuView.FirstOptionsView();
                        int k=scanner.nextInt();
                        switch(k){
                            case(1):{
                                CategoryDisplay.initializeCategories();
                                String user = CurrentUser.getInstance().getUser().getLogin();
                                System.out.println(user);
                            }
                            case(2):{
                                //Aukcje Wystawione przez Usera

                                // UserControllers userControllers = new UserControllers();
//                userControllers.userIsPresent(login,password);

                            }
                            case(3):{
                                //Auckje wygrane przez Usera
                            }
                        }
                    }


                }
                case DURING_REGISTRATION:{
                    HelloMenuView.askForLogin();
                    String login = scanner.next();
                    HelloMenuView.askForPassword();
                    String password = scanner.next();
                    if(userControllers.userRegister(login,password)){
                        HelloMenuView.RegisterConfirmedInformation();
                    }
                }

            }
        }

    }
}
