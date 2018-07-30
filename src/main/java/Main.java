import Exceptions.UserNotExistInBaseException;
import Controllers.UserControllers;
import Controllers.UserList;
import Helpers.UserFileManager;
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
        UserFileManager saveReadManager = new UserFileManager();

        HashMap<String, User> users = (HashMap<String, User>) saveReadManager.readUserFromFileCsv();
        UserList.getInstance().setUserList(users);
        User currentUser;

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
                    try {
                        currentUser = userControllers.userLogin(login, password);
                        state = State.LOGGED_IN;

                    }catch(UserNotExistInBaseException e) {
                        HelloMenuView.WrongAnwser();
                        state = State.DURING_LOGIN;
                    }
                    break;
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
                    break;
                }

                case LOGGED_IN:{
                    LoggedUserMenuView.FirstOptionsView();
                    String answer=scanner.next();
                    switch(answer){
                        case("1"):{
                            CategoryDisplay.initializeCategories();
                            state = State.SHOWING_CATEGORY;
//                            String user = currentUser.getInstance().getUser().getLogin();
//                            System.out.println(user);
                            break;
                        }
                        case("2"):{
                            state = State.LISTING_AUCTIONS;
                            break;
                        }
                        case("3"):{
                            state = State.WINNING_AUCTIONS;
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
                    break;
                }

                case LOGOUT:{
                    state = State.INIT;
                    break;
                }

                case LISTING_AUCTIONS:{
                    break;

                }

                case WINNING_AUCTIONS:{

                }

            }
        }

    }
}
