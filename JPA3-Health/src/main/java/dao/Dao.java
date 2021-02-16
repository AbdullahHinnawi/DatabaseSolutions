package main.java.dao;



import main.java.entity.BasicProfile;
import main.java.entity.Clinic;
import main.java.entity.Customer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.util.List;


public class Dao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

    // Save an object to the database
    public void save(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(object);

        em.getTransaction().commit();
        em.close();
    }

    // Save two objects to the database
    public void save(Object object1, Object object2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(object1);
        em.persist(object2);

        em.getTransaction().commit();
        em.close();
    }

    // OR
    // Save Customer and BasicProfile objects to the database
    public void saveCustomerAndBasicProfile(Customer customer, BasicProfile basicProfile) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(customer);
        em.persist(basicProfile);

        em.getTransaction().commit();
        em.close();
    }

    public Object loadObject(int id){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Object object = em.find(Object.class, id);
        em.getTransaction().commit();
        em.close();

        return object;
    }
    public boolean updateClinic(int id, List<Customer> customers){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Clinic c = em.find(Clinic.class, id);

        if(c!=null){
            for (Customer customer: customers) {
                c.getCustomers().add(customer);
            }
            em.getTransaction().commit();
            return true;
        }
        return false;
    }




}
