package main.java.application;


import main.java.dao.Dao;
import main.java.entity.Account;
import main.java.entity.Category;
import main.java.entity.Transaction;
import java.sql.Timestamp;


public class FinanceTest {

    public static void main(String[] args) {

        /* To run the project successfully:
         - Remember to change the password value in persistence.xml file.
         - Remember to insert mysql-connector jar file to your project, go to:
           file > project structure > libraries > add
        */

        Dao dao = new Dao();
        boolean transactionSuccessful;

        // Generate a few categories
        Category food = new Category("food");
        Category leisure = new Category("leisure");
        Category school = new Category("school");
        Category gifts = new Category("gifts");
        Category internalTransfer = new Category("internalTransfer");

        dao.save(food);
        dao.save(leisure);
        dao.save(school);
        dao.save(gifts);
        dao.save(internalTransfer);

        // Generate a savings account with a 400 € balance
        Account savings = new Account("savings", 400);
        // Generate a wallet with a 14.50 € balance
        Account wallet = new Account("wallet", 14.50);

        dao.save(savings);
        dao.save(wallet);



        // Receive a gift of 100 € from Aunt Mary to the savings account. (The source account should be null)
        Transaction transaction = new Transaction(null, savings, gifts, 100,
                "A gift from Aunt Mary",new Timestamp(System.currentTimeMillis()));

        transactionSuccessful = dao.makeTransaction(transaction);
        System.out.println("Transaction successful: " + transactionSuccessful);

        // Transfer € 40.00 from the savings account to the wallet
        // (internal transfer; specify both the source and destination accounts).
        Transaction transaction2 = new Transaction(savings,wallet, internalTransfer, 40,
                "Internal transfer",new Timestamp(System.currentTimeMillis()));

        transactionSuccessful = dao.makeTransaction(transaction2);
        System.out.println("Transaction successful: " + transactionSuccessful);


       // Spend 8.40 € from the wallet in the pub. (The target account should be null).
        Transaction transaction3 = new Transaction(savings, null, leisure, 8.40,
                "Pub payment",new Timestamp(System.currentTimeMillis()));

        transactionSuccessful = dao.makeTransaction(transaction3);
        System.out.println("Transaction successful: " + transactionSuccessful);







    }


}
