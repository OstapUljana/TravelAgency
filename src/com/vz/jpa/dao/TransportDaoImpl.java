package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class TransportDaoImpl implements TransportDao {
    private static EntityManagerFactory entityManagerFactory = HibernateUtil.buildEntityManagerFactory();

    @Override
    public List<Transport> selectAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT t FROM Transport t");
        List<Transport> transports = query.getResultList();
        entityManager.close();
        return transports;
    }


    @Override
    public Transport selectById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT t  FROM Transport t " +
                "WHERE t.Transport_id = :t_id");
        query.setParameter("t_id", id);
        Transport transport = (Transport) query.getSingleResult();
        entityManager.close();
        return transport;
    }

    @Override
    public int update(Transport transport){
        //one entity manager serving only its own objects
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Transport transport1 = (Transport) entityManager.find(Transport.class, transport.getTransportId());
        if (transport1 == null){
            return 0;
        }
        entityManager.getTransaction().begin();
        transport1.setTransport(transport.getTransport());
        transport1.setTimeArrive(transport.getTimeArrive());
        transport1.setTimeShip(transport.getTimeShip());
        transport1.setCityByShipmentCity(transport.getCityByShipmentCity());
        transport1.setCityByArriveCity(transport.getCityByArriveCity());
        transport1.setPrice(transport.getPrice());
        transport1.setCountryByShipmentCountry(transport.getCountryByShipmentCountry());
        transport1.setCountryByArriveCountry(transport.getCountryByArriveCountry());
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }

    @Override
    public int insert(Transport transport){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(transport);
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
}
