package main.java.application;


import main.java.dao.Dao;
import main.java.entity.Transaction;

import java.util.Scanner;

public class FinanceTest2 {

    public static void main(String[] args) {

        /* To run the project successfully:
         - Remember to change the password value in persistence.xml file.
         - Remember to insert mysql-connector jar file to your project, go to:
           file > project structure > libraries > add
        */

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter transaction id: ");

        int transId = scanner.nextInt();

        Dao dao = new Dao();
        Transaction transaction = dao.getTransaction(transId);

        if(transaction != null) {

            System.out.println("Transaction info:");
            System.out.println("Id: " + transaction.getTransId());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Description: " + transaction.getDescription());
            System.out.println("Date: " + transaction.getTimestamp());
            System.out.println("Category: " + transaction.getCategory().getDescription());
            System.out.println("Source account: " + transaction.getSourceAccount().getAccountName());
            System.out.println("Destination account: " + transaction.getDestinationAccount().getAccountName());
        }else{
            System.out.println("Transaction not found!");
        }









    }
}
