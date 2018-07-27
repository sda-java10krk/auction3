package Helpers;

import Controllers.UserList;

import Models.Auction;
import Models.User;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SaveReadManager {


    public void saveUserToFile(Map<String, User> map) {

        String fileName1 = "UserList.txt";
        try {
            FileOutputStream fileWriter1 = new FileOutputStream(fileName1);
            ObjectOutputStream writer1 = new ObjectOutputStream(fileWriter1);
            {
                writer1.writeObject(map);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName1);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName1);
        }
    }


    public HashMap<String, User> readUserFromFile() {

        String fileName1 = "UserList.txt";
        try {
            FileInputStream fileReader1 = new FileInputStream(fileName1);
            ObjectInputStream reader1 = new ObjectInputStream(fileReader1);
            {
                return (HashMap<String, User>) reader1.readObject();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName1);
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu danych z pliku " + fileName1);
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
        }
        return null;
    }


    public void saveOffersToAuction(List<Auction> list) {

        String fileName2 = "AuctionsList.txt";
        try {
            FileOutputStream fileWriter2 = new FileOutputStream(fileName2);
            ObjectOutputStream writer2 = new ObjectOutputStream(fileWriter2);
            {
                writer2.writeObject(list);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName2);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + fileName2);
        }
    }


    public LinkedList<Auction> readAuctionToOffers() {

        String fileName2 = "AuctionsList.txt";

        try {
            FileInputStream fileReader2 = new FileInputStream(fileName2);
            ObjectInputStream reader2 = new ObjectInputStream(fileReader2);
            {
                return (LinkedList<Auction>) reader2.readObject();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + fileName2);
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu danych z pliku " + fileName2);
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
        }
        return null;
    }
}

