package main.java.dao;

import main.java.entity.*;
import javax.persistence.*;


public class Dao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harj1PU");

    public void saveAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(account);

        em.getTransaction().commit();
        em.close();
    }

    public Account loadAccount(int id){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account a = em.find(Account.class, id);
        em.getTransaction().commit();
        em.close();

        return a;
    }

    public void transfer(int sourceAccountId, int destinationAccountId, double amount){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account sourceAccount = em.find(Account.class,sourceAccountId);
        Account destinationAccount = em.find(Account.class,destinationAccountId);

        double sourceNewBalance = sourceAccount.getBalance() - amount;
        double destinationNewBalance = destinationAccount.getBalance() + amount;

        sourceAccount.setBalance(sourceNewBalance);
        destinationAccount.setBalance(destinationNewBalance);

        em.getTransaction().commit();
        em.close();

    }


}
