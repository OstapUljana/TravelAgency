package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import java.util.List;


public class ClientDaoImpl implements ClientDao {
    private static EntityManagerFactory entityManagerFactory = HibernateUtil.buildEntityManagerFactory();

    @Override
    public List<Client> selectAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM Client c");
        List<Client> clients = query.getResultList();
        entityManager.close();
        return clients;
    }
    
    @Override
    public Client selectById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM Client c WHERE c.clientId = :c_id");
        query.setParameter("c_id",id);
        Client client = (Client) query.getSingleResult();
        entityManager.close();
        return client;
    }
    
    @Override
    public boolean clientExistCheck(String email, String password) {
  	  EntityManager entityManager = entityManagerFactory.createEntityManager();
  	  Client client;
  	  try {
  		  Query query = entityManager.createQuery("SELECT c FROM Client c WHERE "
  				  + "c.eMail = :email AND c.password = :pass ");
  		  query.setParameter("pass", password);
  		  query.setParameter("email", email);
  		  client = (Client) query.getSingleResult();
  	  } catch (javax.persistence.NoResultException e) {
  		  	return false;
  	  }
  	  	entityManager.close();
  	  	return true;
  	 }

    @Override
    public Client selectByEmailandPassword(String email, String password){
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	Client client;
    	try{
    		Query query = entityManager.createQuery("SELECT c FROM Client c WHERE "
    				+ "c.eMail = :email AND c.password = :pass ");
    		query.setParameter("pass", password);
    		query.setParameter("email", email);
    		client = (Client) query.getSingleResult();    		
    	} catch(javax.persistence.NoResultException e){
    		client = new Client();   		
    	}
    	entityManager.close();
    	return client;
    }
    
    @Override
    public boolean selectByEmail(String email){
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
      	try{
    		Query query = entityManager.createQuery("SELECT c FROM Client c WHERE "
    				+ "c.eMail = :email");
    		query.setParameter("email", email);
    		Client client = (Client) query.getSingleResult();
    		entityManager.close();
    		return true;
    	} catch (javax.persistence.NoResultException e){
    		entityManager.close();
    		return false;
    	}    	
    }
    
    @Override
    public int update(Client client){
        //one entity manager serving only its own objects
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Client client1 = (Client) entityManager.find(Client.class, client.getClientId());

        if (client1 == null){
            return 0;
        }

        entityManager.getTransaction().begin();
        client1.setCountryByCountryId(client.getCountryByCountryId());
        client1.setCityByCityId(client.getCityByCityId());
        client1.setName(client.getName());
        client1.setSurname(client.getSurname());
        client1.setSex(client.getSex());
        client1.setBirthday(client.getBirthday());
        client1.setPhone(client.getPhone());
        client1.seteMail(client.geteMail());
        client1.setPassword(client.getPassword());
        client1.setPassport(client.getPassport());
        client1.setInn(client.getInn());
        client1.setVisa(client.getVisa());
        client1.setComment(client.getComment());
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
    
    @Override    
    public Client insert(Client client){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
        return client;
    }
}
