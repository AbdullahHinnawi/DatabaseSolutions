package main.java.application;



import main.java.dao.Dao;
import main.java.entity.*;
import java.util.List;

public class KassaApp {


    public static void initDB(Dao dao) {
        final int NUM_REGISTERS = 5;
        final int NUM_EVENTS = 10;
        // initialize registers
        for (int i = 1; i<=NUM_REGISTERS; i++) {
            Register reg = new Register(i, "Kassapiste_" + i);
            dao.addRegister(reg);
        }
        // initialize events
        for (int i = 1; i<=NUM_EVENTS; i++) {
            int regnum = (int)(Math.random()*NUM_REGISTERS)+1;
            // amount between 1.00 - 99.99
            double amount = (int)(100+Math.random()*9900)/100.0;
            dao.addEvent(i, regnum, amount);
        }
    }

    public static void main(String[] args) {

        Dao dao = new Dao();
        initDB(dao);

        // ***** JPQL *****

        /*
        //  1-a
        List<SalesEvent> result = dao.retrieveSmallSales(50.0);
        System.out.println("Sales Events whose amount is less than 50.0: ");
        if (result!=null) {
            for (SalesEvent s : result) {
                System.out.println(s + " at register " + s.getRegister());
            }
        }

        //  1-b
        int eventsAffected = dao.addServiceFee(1.99);
        System.out.println("The number of events to which a service fee added: " + eventsAffected);

        //  1-c
       int eventsDeleted = dao.deleteAllSalesEvents();
       System.out.println("The number of events that have been deleted: " + eventsDeleted);

        */


       // ***** Java Criteria API *****


        //  1-a
        List<SalesEvent> result2 = dao.getSalesByAmount(50.0);
        System.out.println("Sales Events whose amount is less than 50.0: ");
        if (result2!=null) {
            for (SalesEvent s : result2) {
                System.out.println(s + " at register " + s.getRegister());
            }
        }

        //  1-b
        int eventsAffected = dao.addServiceFee2(2.35);
        System.out.println("The number of events to which a service fee added: " + eventsAffected);

        //  1-c
        int eventsDeleted = dao.deleteAllSalesEvents2();
        System.out.println("The number of events that have been deleted: " + eventsDeleted);








    }
}


