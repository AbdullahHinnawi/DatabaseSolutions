package main.java.entity;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int custId;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "customer")
    private BasicProfile basicProfile;


    public Customer(){

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCustId() {
        return custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BasicProfile getBasicProfile() {
        return basicProfile;
    }

    public void setBasicProfile(BasicProfile basicProfile) {
        this.basicProfile = basicProfile;
    }
}
