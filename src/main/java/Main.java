import Controllers.AuctionControllers;
import Controllers.OfferController;
import Controllers.UserControllers;
import Controllers.UserList;
import Exceptions.UserNotExistInBaseException;
import Helpers.*;
import Models.Auction;
import Models.AuctionsDatabase;
import Models.Category;
import Models.User;
import Models.*;
import Views.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws Exception {

        int n = 0;
        Scanner scanner = new Scanner(System.in);
        State state = State.INIT;
        User currentUser = null;

        UserControllers userControllers = new UserControllers();
        OfferController offerController = new OfferController();

        UserFileManager userFileManager = new UserFileManager();
        AuctionFileManager auctionFileManager = new AuctionFileManager();
        AuctionFileCounterManager auctionFileCounterManager = new AuctionFileCounterManager();
        OfferFileCounterManager offerFileCounterManager = new OfferFileCounterManager();
        OfferFileManager offerFileManager = new OfferFileManager();

        userFileManager.ExistFileUserCSV();
        auctionFileManager.ExistFileAuctionCSV();
        auctionFileCounterManager.ExistFileAuctionCounterCSV();
        offerFileManager.ExistFileOfferCSV();
        offerFileCounterManager.ExistFileOfferCounterCSV();

        Map<String, User> users = userFileManager.readUserFromFileCsv();

        Map<Integer, Auction> auctions = auctionFileManager.readAuctionFromFileCsv();
        AuctionsDatabase.getInstance().setCurrentAuctionsMap(auctions);

        UserList.getInstance().setUserList(users);


        while (state != State.STOP) {
            switch (state) {
                case INIT: {
                    HelloMenuView.helloView();
                    String answer = scanner.next();
                    switch (answer) {
                        case ("1"): {
                            state = State.DURING_LOGIN;
                            break;
                        }
                        case ("2"): {
                            state = State.DURING_REGISTRATION;
                            break;
                        }
                        case ("3"): {
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
                case DURING_LOGIN: {
                    HelloMenuView.askForLogin();
                    String login = scanner.next();
                    HelloMenuView.askForPassword();
                    String password = scanner.next();
                    try {
                        currentUser = userControllers.userLogin(login, password);
                        state = State.LOGGED_IN;

                    } catch (UserNotExistInBaseException e) {
                        HelloMenuView.WrongAnwser();
                        state = State.DURING_LOGIN;
                    }
                    break;
                }
                case DURING_REGISTRATION: {
                    HelloMenuView.askForLogin();
                    String login = scanner.next();
                    HelloMenuView.askForPassword();
                    String password = scanner.next();
                    if (userControllers.userRegister(login, password)) {
                        HelloMenuView.RegisterConfirmedInformation();
                        state = State.DURING_LOGIN;
                    } else {
                        HelloMenuView.WrongAnwser();
                        state = State.DURING_REGISTRATION;
                    }
                    break;
                }

                case LOGGED_IN: {
                    LoggedUserMenuView.FirstOptionsView();
                    String answer = scanner.next();
                    CategoryDisplay.printCategoryTree();
                    switch (answer) {
                        case ("1"): {
                            state = State.SHOWING_CATEGORY;
                            //
//                            String user = currentUser.getInstance().getUser().getLogin();
//                            System.out.println(user);
                            break;
                        }
                        case ("2"): {
                            state = State.LISTING_AUCTIONS;
                            break;
                        }
                        case ("3"): {
                            state = State.WINNING_AUCTIONS;
                            break;
                        }
                        case ("4"): {
                            state = State.LOGOUT;
                            break;
                        }
                        case ("5"): {
                            state = State.STOP;
                            break;
                        }
                    }
                    break;
                }

                case SHOWING_CATEGORY: {
                    CategoryDisplay.printCategoryTree();
                    LoggedUserMenuView.TreeViewOptions();
                    String answer = scanner.next();
                    switch (answer) {
                        case ("1"): {
                            state = State.ADDING_AUCTION;
                            break;

                        }
                        case ("2"): {
                            state = State.MAKING_OFFER;
                            break;

                        }
                        case ("4"): {
                            state = State.WINNING_AUCTIONS;
                            break;

                        }
                        case ("5"): {
                            state = State.LOGOUT;
                            break;
                        }
                        case ("6"): {
                            state = State.STOP;
                            break;
                        }
                        case ("7"): {
                            state = State.LISTING_AUCTIONS;
                            break;
                        }
                    }
                    break;
                }

                case LOGOUT: {
                    state = State.INIT;
                    break;
                }

                case ADDING_AUCTION: {
                    AddingAuctionView.settingAuctionTitle();
                    String title = scanner.next();
                    AddingAuctionView.settingAuctionDescription();
                    String description = scanner.next();
                    AddingAuctionView.settingStartingPrice();
                    BigDecimal startingPrice = scanner.nextBigDecimal();
                    AddingAuctionView.settingCategory();
                    String categoryId = scanner.next();
                    Category category = CategoriesDatabase.getInstance().findCategoryByString(categoryId);
                    Integer counter = auctionFileCounterManager.readAuctionCounterFromFileCsv();
                    AuctionControllers.getInstance().createAuction(currentUser, title, description, startingPrice, category, counter);
                    auctionFileCounterManager.saveAuctionCounterToFileCSV(counter);

                    state = State.SHOWING_CATEGORY;
                    break;
                }

                case MAKING_OFFER: {
                    AddingOfferView.GetAuctionId();
                    int id = scanner.nextInt();
                    MakingOfferView.askingForPrice();
                    BigDecimal price = scanner.nextBigDecimal();


//                    if (AuctionControllers.getInstance().AuctionList.containsKey(id)) {
                    Offer offer = offerController.creatingOffer(currentUser, price,AuctionsDatabase.getInstance().getCurrentAuctions(currentUser).get(id));
                    offerController.addOffer(AuctionsDatabase.getInstance().getCurrentAuctionsMap().get(id), offer);
                    AddingOfferView.NewOfferCreate();
//                    }
//                    else
//                        AddingOfferView.Error();
                    state = State.SHOWING_CATEGORY;
                    break;

                }
                case LISTING_AUCTIONS: {


                }
                Map<Integer, Auction> map = AuctionsDatabase.getInstance().getCurrentAuctionsMap();
                LoggedUserMenuView.TreeViewOptions();
                String answer = scanner.next();
                switch (answer) {
                    case ("1"): {
                        state = State.ADDING_AUCTION;

                        for(Map.Entry entry : map.entrySet()) {
                            System.out.println(entry.getKey() + ", " + entry.getValue());
                        }


                        LoggedUserMenuView.TreeViewOptions();
                        String answer1 = scanner.next();
                        switch (answer1) {
                            case ("1"): {
                                state = State.ADDING_AUCTION;
                                break;

                            }
                            case ("2"): {
                                state = State.MAKING_OFFER;
                                break;

                            }
                            case ("4"): {
                                state = State.WINNING_AUCTIONS;
                                break;

                            }
                            case ("5"): {
                                state = State.LOGOUT;
                                break;
                            }
                            case ("6"): {
                                state = State.STOP;
                                break;
                            }
                            case ("7"): {
                                state = State.LISTING_AUCTIONS;
                                break;
                            }
                        }
                        break;
                    }

//                    case WINNING_AUCTIONS: {

                    }


                }
            }

        }
    }

/*
rozkminic countera
zapisywanie oferty
zwyciesto aukcji (3 oferta)
usuniecie aukcji po zwyciestwie ( osobna mapa na zakonczone aukcje)

*/