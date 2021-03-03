package main.java.application;

import main.java.dao.Dao;
import main.java.entity.Account;


public class App {


    public static void main(String[] args) {


        Dao dao = new Dao();


        Account account1 = new Account("FI5723454567823423", 123.45);
        Account account2 = new Account("FI5830006666232334", 1234567.45);

        dao.saveAccount(account1);
        dao.saveAccount(account2);


        Account retrieved1 = dao.loadAccount(1);
        Account retrieved2 = dao.loadAccount(2);


        System.out.println("Retrieved1 info:");
        System.out.println("id: " + retrieved1.getId() + "     number: " + retrieved1.getNumber() + "     balance: " + retrieved1.getBalance());

        System.out.println("Retrieved2 info:");
        System.out.println("id: " + retrieved2.getId() + "     number: " + retrieved2.getNumber() + "     balance: " + retrieved2.getBalance());


        dao.transfer(account1.getId(), account2.getId(),100.05);


        retrieved1 = dao.loadAccount(1);
        retrieved2 = dao.loadAccount(2);


        System.out.println("Retrieved1 info:");
        System.out.println("id: " + retrieved1.getId() + "     number: " + retrieved1.getNumber() + "     balance: " + retrieved1.getBalance());

        System.out.println("Retrieved2 info:");
        System.out.println("id: " + retrieved2.getId() + "     number: " + retrieved2.getNumber() + "     balance: " + retrieved2.getBalance());

        System.out.println("Done");


    }
}
