package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class CountryDaoImpl implements CountryDao {
    private static EntityManagerFactory entityManagerFactory = HibernateUtil.buildEntityManagerFactory();

    @Override
    public List<Country> selectAllCountry(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM Country c");
        List<Country> countries = query.getResultList();
        entityManager.close();
        return countries;
    }
    @Override
    public Country selectById(int country_id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM Country c WHERE c.countryId = :c_id");
        query.setParameter("c_id",country_id);
        Country country = (Country) query.getSingleResult();
        entityManager.close();
        return country;
    }

    @Override
    public int update(Country country){
        //one entity manager serving only its own objects
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       Country country1 = (Country) entityManager.find(Country.class, country.getCountryId());

        if (country1 == null){
            return 0;
        }

        entityManager.getTransaction().begin();
        country1.setCountry(country.getCountry());
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
    @Override
    public int insert(Country country){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
    /*@Override
    public List<City> selectAllCityInThisCountry(int country_id){

    }*/
}
