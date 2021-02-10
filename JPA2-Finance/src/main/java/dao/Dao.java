package main.java.dao;

import main.java.entity.Account;
import main.java.entity.Transaction;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;


public class Dao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

    private static EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("DevPU2");

    // Save an object which could be account, category or transaction.
    public void save(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(object);

        em.getTransaction().commit();
        em.close();
    }

    public boolean makeTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean succeed = false;

        if(transaction.getSourceAccount() == null){
            Account destination = em.find(Account.class, transaction.getDestinationAccount().getAccountId());
            if(destination!= null){
                destination.setBalance(destination.getBalance() + transaction.getAmount());
                succeed = true;
            }
        }else if(transaction.getDestinationAccount() == null){
            Account source = em.find(Account.class, transaction.getSourceAccount().getAccountId());
            if(source != null){
                source.setBalance(source.getBalance() - transaction.getAmount());
                succeed = true;
            }
        }else{
            Account source = em.find(Account.class, transaction.getSourceAccount().getAccountId());
            Account destination = em.find(Account.class, transaction.getDestinationAccount().getAccountId());
            if(source != null && destination != null){
                source.setBalance(source.getBalance()-transaction.getAmount());
                destination.setBalance(destination.getBalance()+transaction.getAmount());
                succeed = true;
            }
        }
        if(succeed){
            // Save the transaction and commit the changes to the database
            em.persist(transaction);
            em.getTransaction().commit();

        }
        em.close();
        return succeed;

    }

    // get a transaction by id
    public Transaction getTransaction(int id){

        EntityManager em = emf2.createEntityManager();
        em.getTransaction().begin();

        Transaction t = em.find(Transaction.class, id);
        em.getTransaction().commit();
        em.close();

        return t;
    }


}