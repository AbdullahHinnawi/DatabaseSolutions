package main.java.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ContractCustomer extends Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    @Temporal(value = TemporalType.DATE)
    private Date startDate;
    @Temporal(value = TemporalType.DATE)
    private Date endDate;


    public ContractCustomer(){

    }

    public ContractCustomer(String firstName, String lastName, Date startDate, Date endDate) {
        super(firstName, lastName);
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
