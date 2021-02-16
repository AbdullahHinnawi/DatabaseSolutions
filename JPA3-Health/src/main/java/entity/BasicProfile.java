package main.java.entity;

import javax.persistence.*;


@Entity
public class BasicProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private String birthYear;
    private double weight;
    private double height;

    @JoinColumn
    @OneToOne(optional = false)
    @MapsId
    private Customer customer;

    public BasicProfile(){

    }

    public BasicProfile(String birthYear, double weight, double height, Customer customer) {
        this.birthYear = birthYear;
        this.weight = weight;
        this.height = height;
        this.customer = customer;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
