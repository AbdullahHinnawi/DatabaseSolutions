package main.java.application;

import main.java.dao.Dao;
import main.java.entity.BasicProfile;
import main.java.entity.Clinic;
import main.java.entity.ContractCustomer;
import main.java.entity.Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /* To run the project successfully:
         - Remember to change the password value in persistence.xml file.
         - Remember to insert mysql-connector jar file to your project, go to:
           file > project structure > libraries > add
        */

        Dao dao = new Dao();

        Customer customer1 = new Customer("Anna", "Jones");
        Customer customer2 = new Customer("Bill", "Smith");

        BasicProfile basicProfile1 = new BasicProfile("1980", 60.5, 170.0, customer1);
        BasicProfile basicProfile2 = new BasicProfile("1980", 77.5, 180.0, customer2);

        Clinic clinic = new Clinic();
        clinic.setLocation("'Helsinki");
        clinic.getCustomers().add(customer1);
        clinic.getCustomers().add(customer2);

        //dao.save(customer1);
        //dao.save(customer2);

        //dao.save(basicProfile1);
        //dao.save(basicProfile2);

        dao.save(customer1, basicProfile1);
        dao.save(customer2,basicProfile2);

        dao.save(clinic);

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        startDate.set(2021, Calendar.JANUARY, 1);
        endDate.set(2021, Calendar.DECEMBER, 31);

        ContractCustomer contractCustomer1 = new ContractCustomer("Marko", "Väisänen",startDate.getTime(), endDate.getTime());


        startDate.set(2021, Calendar.FEBRUARY, 1);
        endDate.set(2022, Calendar.JANUARY, 31);

        ContractCustomer contractCustomer2 = new ContractCustomer("Laura", "Rusanen", startDate.getTime(), endDate.getTime());

        dao.save(contractCustomer1);
        dao.save(contractCustomer2);


        List<Customer> contractCustomers = new ArrayList<>();

        contractCustomers.add(contractCustomer1);
        contractCustomers.add(contractCustomer2);

        dao.updateClinic(clinic.getClinicId(), contractCustomers);

        System.out.println("Done");


    }


}
