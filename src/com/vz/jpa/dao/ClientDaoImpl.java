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
        Query query = entityManager.createQuery("SELECT Client_id, Name, Surname, Birthday, Sex, " +
                "Phone, E_mail, Password, City_id, Passport, INN, Visa, Comment, Country_id FROM Client ");
        List<Client> clients = query.getResultList();
        entityManager.close();
        return clients;
    }
    
    @Override
    public Client selectById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT  Client_id, Name, Surname, Birthday, Sex,Phone, " +
                "E_mail, Password, City_id, Passport, INN, Visa, Comment, Country_id FROM Client WHERE City_id = :c_id");
        query.setParameter("c_id",id);
        Client client = (Client) query.getSingleResult();
        entityManager.close();
        return client;
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
    
    /*@Override
    public List<Client> selectByEmailandPassword(String email, String password){
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     Query query = entityManager.createQuery("SELECT eMail, password FROM Client WHERE "
       + "eMail = :email AND password = :pass ");
        query.setParameter("pass", password);
        query.setParameter("email", email);
     List<Object> result = query.getResultList();
	  List<Client> user = new ArrayList<Client>();
	  Iterator itr = result.iterator();
	  while (itr.hasNext()) {
		   Client temp = new Client();
		   Object[] obj = (Object[]) itr.next();
		   temp.seteMail(String.valueOf(obj[0]));
		   temp.setPassword(String.valueOf(obj[1]));
		   user.add(temp);
	  }
	  entityManager.close();
	  String msg;
	  if(user.isEmpty()){
		  msg="This user don`t exists";
	  }else{
		  msg="This user exists";
	  }
	  return user;
    }
    */
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
    public Client selectByEmailClient (String email){
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
      	try{
    		Query query = entityManager.createQuery("SELECT c FROM Client c WHERE "
    				+ "c.eMail = :email");
    		query.setParameter("email", email);
    		Client client = (Client) query.getSingleResult();
    		entityManager.close();
    		return client;
    	} catch (javax.persistence.NoResultException e){
    		entityManager.close();
    		return null;
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
        client1.setPhone(client.getPhone());/*
        client1.seteMail(client.geteMail());
        client1.setPassword(client.getPassword());*/
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
