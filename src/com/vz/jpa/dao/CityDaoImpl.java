package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class CityDaoImpl implements CityDao {

    private static EntityManagerFactory entityManagerFactory = HibernateUtil.buildEntityManagerFactory();

    @Override
    public List<City> selectAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM City c");
        List<City> cities = query.getResultList();
        entityManager.close();
        return cities;
    }
   
    @Override
    public City selectById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM City c WHERE c.cityId = :c_id");
        query.setParameter("c_id",id);
        City city = (City) query.getSingleResult();
        entityManager.close();
        return city;
    }

    @Override
    public int update(City city){
        //one entity manager serving only its own objects
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        City city1 = (City) entityManager.find(City.class, city.getCityId());

        if (city1 == null){
            return 0;
        }

        entityManager.getTransaction().begin();
        city1.setCountryByCountryId(city.getCountryByCountryId());
        city1.setName(city.getName());
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
   
    @Override
    public int insert(City city){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
        /*@Override
    public City selectByName(String name){

    }*/
}
