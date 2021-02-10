package main.java.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transId;
    private double amount;
    private String description;
    private Timestamp timestamp;

    // In a @ManyToOne association the default fetch type is EAGER (fetch= FetchType.EAGER)
    @ManyToOne//(fetch= FetchType.LAZY)
    private Category category;

    @ManyToOne//(fetch= FetchType.LAZY)
    @JoinColumn(nullable = true)
    private Account sourceAccount;


    @ManyToOne//(fetch= FetchType.LAZY)
    @JoinColumn(nullable = true)
    private Account destinationAccount;

    public Transaction() {
    }
    public Transaction(Account sourceAccount, Account destinationAccount,Category category, double amount, String description, Timestamp timestamp) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
    }


    public int getTransId() {
        return transId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
