package main.java.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicId;
    private String location;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Customer> customers = new ArrayList<Customer>();

    public Clinic(){

    }

    public int getClinicId() {
        return clinicId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
