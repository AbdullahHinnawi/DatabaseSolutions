package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

	public void saveDevice(Device device) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(device);
        
        em.getTransaction().commit();
        em.close();
	}

	public Device loadDevice(int id){

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Device d = em.find(Device.class, id);
		em.getTransaction().commit();
		em.close();

		return d;
	}

	public boolean updateDeviceDescription(int id, String newDescription){

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Device d = em.find(Device.class, id);

		if(d!=null){
			d.setDescription(newDescription);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public boolean removeDevice(int id){

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Device d = em.find(Device.class, id);

		if(d != null){
			em.remove(d);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}












}
