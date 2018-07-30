import Controllers.AuctionControllers;
import Exceptions.LoginNotGoneWellExeption;
import Exceptions.UserNotExistInBaseException;
import Helpers.SaveReadManager;
import Controllers.UserControllers;
import Controllers.UserList;
import Helpers.UserFileManager;
import Models.Auction;
import Models.AuctionsDatabase;
import Controllers.UserControllers;
import Controllers.UserList;
import Helpers.SaveReadManager;
import Models.Category;
import Models.User;
import Views.AddingAuctionView;
import Views.CategoryDisplay;
import Views.HelloMenuView;
import Views.LoggedUserMenuView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int n=0;
        Scanner scanner = new Scanner(System.in);
        State state = State.INIT;
        UserControllers userControllers = new UserControllers();
        UserFileManager userFileManager = new UserFileManager();

        Map<String, User> users = userFileManager.readUserFromFileCsv();
        UserList.getInstance().setUserList(users);
        User currentUser=null;

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
                        state = State.DURING_LOGIN;
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
                            state = State.ADDING_AUCTION;
                            break;

                        }
                        case("2"):{
                            state = State.MAKING_OFFER;
                            break;

                        }
                        case("4"):{
                            state = State.WINNING_AUCTIONS;
                            break;

                        }
                        case("5"):{
                            state = State.LOGOUT;
                            break;
                        }
                        case("6"):{
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

                case ADDING_AUCTION:{
                    AddingAuctionView.settingAuctionTitle();
                    String title=scanner.next();
                    AddingAuctionView.settingAuctionDescription();
                    String description=scanner.next();
                    AddingAuctionView.settingStartingPrice();
                    BigDecimal startingPrice = scanner.nextBigDecimal();
                    AddingAuctionView.settingCategory();
                    String category = scanner.next();

                    Category categoryTemp = new Category(category);
                    Auction auction = AuctionControllers.getInstance().createAuction(currentUser,title,description,startingPrice,categoryTemp);
                    AuctionsDatabase.getInstance().addCurrentAuction(auction);
                    AuctionsDatabase.getInstance().getCurrentAuctions(currentUser);
                    state = State.SHOWING_CATEGORY;
                    break;
                }

                case MAKING_OFFER:{

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
