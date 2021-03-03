package main.java.entity;

import main.java.converter.DoubleConverter;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;

    @Convert(converter = DoubleConverter.class)
    private double balance;

    @Version
    private long version;


    public Account() {

    }

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getVersion() {
        return version;
    }
}
