package main.java.dao;

import main.java.entity.*;
import javax.persistence.*;
import javax.persistence.criteria.*;

// import javax.persistence.criteria.*;


import java.util.*;



public class Dao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harj1PU");

    public void addRegister(Register reg) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(reg);

        em.getTransaction().commit();
        em.close();
    }

    public void addEvent(int eventNumber, int regNumber, double amount) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Register reg = em.find(Register.class, regNumber);
        SalesEvent evt = new SalesEvent(eventNumber, reg, amount);

        em.persist(evt);

        em.getTransaction().commit();
        em.close();
    }

    public List<SalesEvent> retrieveSmallSales(double limit) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String statement = "SELECT s FROM SalesEvent s WHERE amount < " + limit;
        Query query = em.createQuery(statement);
        List<SalesEvent> result = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public int addServiceFee(double serviceFee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String statement = "UPDATE SalesEvent SET amount = amount + " + serviceFee;
        Query query = em.createQuery(statement);
        int eventsAffected = query.executeUpdate();

        em.getTransaction().commit();
        em.close();
        return eventsAffected;
    }

    public int deleteAllSalesEvents(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String statement = "DELETE FROM SalesEvent";
        Query query = em.createQuery(statement);
        int eventsDeleted = query.executeUpdate();

        em.getTransaction().commit();
        em.close();
        return eventsDeleted;
    }


    // ***** Java Criteria Methods *****

    public List<SalesEvent> getSalesByAmount(double limit) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SalesEvent> cq = cb.createQuery(SalesEvent.class);
        Root<SalesEvent> salesEventRoot = cq.from(SalesEvent.class);
        // cb.lessThan: create a predicate for testing whether the first
        // argument is less than the second (limit).
        cq.select(salesEventRoot).where(cb.lessThan(salesEventRoot.get(SalesEvent_.amount),limit));
        TypedQuery<SalesEvent> typedQuery = em.createQuery(cq);
        List<SalesEvent> result = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public int addServiceFee2(double serviceFee) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        // create update
        CriteriaUpdate<SalesEvent> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(SalesEvent.class);
        // set the root class
        Root<SalesEvent> salesEventRoot = criteriaUpdate.from(SalesEvent.class);

        criteriaUpdate.set(salesEventRoot.get(SalesEvent_.amount),criteriaBuilder.sum(salesEventRoot.get(SalesEvent_.AMOUNT), serviceFee));

         // perform update
        em.getTransaction().begin();
        int rowsUpdated = em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();
        em.close();

        return rowsUpdated;
    }

    public int deleteAllSalesEvents2(){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<SalesEvent>  criteriaDelete = criteriaBuilder.createCriteriaDelete(SalesEvent.class);
        criteriaDelete.from(SalesEvent.class);

        em.getTransaction().begin();
        int eventsDeleted = em.createQuery(criteriaDelete).executeUpdate();
        em.getTransaction().commit();
        em.close();
        return eventsDeleted;
    }

}

