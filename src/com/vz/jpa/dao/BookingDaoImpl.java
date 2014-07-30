package com.vz.jpa.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import java.util.List;


public class BookingDaoImpl implements BookingDao{

    private static EntityManagerFactory entityManagerFactory = HibernateUtil.buildEntityManagerFactory();

    @Override
    public List<Booking> selectAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT b FROM Booking b ");
        List <Booking> bookings = query.getResultList();
        entityManager.close();
        return bookings;
    }

    @Override
    public Booking selectById(int booking_id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT b FROM Booking b WHERE b.bookingId = :b_id");
        query.setParameter("b_id",booking_id);
        Booking booking = (Booking) query.getSingleResult();
        entityManager.close();
        return booking;
    }

    @Override
    public int update(Booking booking){
        //one entity manager serving only its own objects
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Booking booking1 = (Booking) entityManager.find(Booking.class, booking.getBookingId());

        if (booking1 == null){
            return 0;
        }

        entityManager.getTransaction().begin();
        booking1.setStatus(booking.getStatus());
        booking1.setClientByClientId(booking.getClientByClientId());
        booking1.setTourByTourId(booking.getTourByTourId());
        booking1.setAdministratorByAdministratorId(booking.getAdministratorByAdministratorId());
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }

    @Override
    public int insert(Booking booking){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(booking);
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
}
