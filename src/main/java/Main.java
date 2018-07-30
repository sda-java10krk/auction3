import Controllers.AuctionControllers;
import Controllers.UserControllers;
import Controllers.UserList;
import Helpers.SaveReadManager;
import Models.User;
import Views.CategoryDisplay;
import Views.HelloMenuView;
import Views.LoggedUserMenuView;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int n=0;
        Scanner scanner = new Scanner(System.in);
        State state = State.INIT;

        UserControllers userControllers = new UserControllers();
        SaveReadManager saveReadManager = new SaveReadManager();

        HashMap<String, User> users = saveReadManager.readUserFromFile();

        UserList.getInstance().setUserList(users);

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
                        state = State.LOGGED_IN;
                        break;
                    }
                    else{
                        HelloMenuView.WrongAnwser();
                        state = State.DURING_LOGIN;
                        break;
                    }
                }
                case DURING_REGISTRATION:{
                    HelloMenuView.askForLogin();
                    String login = scanner.next();
                    HelloMenuView.askForPassword();
                    String password = scanner.next();
                    if(userControllers.userRegister(login,password)){
                        HelloMenuView.RegisterConfirmedInformation();
                        state = State.LOGGED_IN;
                    }else{
                        HelloMenuView.WrongAnwser();
                        state = State.DURING_REGISTRATION;
                    }
                }

                case LOGGED_IN:{
                    LoggedUserMenuView.FirstOptionsView();
                    String answer=scanner.next();
                    switch(answer){
                        case("1"):{
                            CategoryDisplay.initializeCategories();
                            state = State.SHOWING_CATEGORY;
                            break;
                        }
                        case("2"):{
                            state = State.LISTING_AUCTIONS;
                            //Aukcje Wystawione przez Usera

                            // UserControllers userControllers = new UserControllers();
//                userControllers.userIsPresent(login,password);
                            break;

                        }
                        case("3"):{
                            state = State.WINNING_AUCTIONS;
                            //Auckje wygrane przez Usera
                            break;
                        }
                        case("4"):{
                            state = State.LOGOUT;
                            break;
                        }
                        case("5"):{
                            state = State.STOP;
                            break;
                        }
                    }
                    break;
                }

                case SHOWING_CATEGORY:{
                    CategoryDisplay.initializeCategories();
                    LoggedUserMenuView.TreeViewOptions();
                    String answer = scanner.next();
                    switch(answer){
                        case("1"):{
                            state = State.LISTING_AUCTIONS;
                            break;

                        }
                        case("2"):{
                            state = State.WINNING_AUCTIONS;
                            break;

                        }
                        case("3"):{
                            state = State.LOGOUT;
                            break;

                        }
                        case("4"):{
                            state = State.STOP;
                            break;

                        }


                    }
                }

                case LOGOUT:{
                    state = State.INIT;
                    break;
                }

                case LISTING_AUCTIONS:{
                    AuctionControllers auctionControllers = new AuctionControllers();
                    break;

                }

                case WINNING_AUCTIONS:{

                }

            }
        }

    }
}
