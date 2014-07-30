package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class HotelDaoImpl implements HotelDao{
    private static EntityManagerFactory entityManagerFactory = HibernateUtil.buildEntityManagerFactory();
    @Override
    public List<Hotel> selectAllHotels(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT h FROM Hotel h");
        List<Hotel> hotels = query.getResultList();
        entityManager.close();
        return hotels;
    }
    @Override
    public Hotel selectById(int hotel_id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT h FROM Hotel h WHERE h.hotelId = :h_id");
        query.setParameter("h_id",hotel_id);
        Hotel hotel = (Hotel) query.getSingleResult();
        entityManager.close();
        return hotel;
    }
    @Override
    public int update(Hotel hotel){
        //one entity manager serving only its own objects
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Hotel hotel1 = (Hotel) entityManager.find(Hotel.class, hotel.getHotelId());

        if (hotel1 == null){
            return 0;
        }

        entityManager.getTransaction().begin();
        hotel1.setCountryByCountryId(hotel.getCountryByCountryId());
        hotel1.setCityByCityId(hotel.getCityByCityId());
        hotel1.setFullName(hotel.getFullName());
        hotel1.setShortName(hotel.getShortName());
        hotel1.setLocation(hotel.getLocation());
        hotel1.setTypeHotel(hotel.getTypeHotel());
        hotel1.setTypeOfHotelRoom(hotel.getTypeOfHotelRoom());
        hotel1.seteMail(hotel.geteMail());
        hotel1.setPhone1(hotel.getPhone1());
        hotel1.setPhone2(hotel.getPhone2());
        hotel1.setFax(hotel.getFax());
        hotel1.setStars(hotel.getStars());
        hotel1.setRating(hotel.getRating());
        hotel1.setDescription(hotel.getDescription());
        hotel1.setPeople(hotel.getPeople());
        hotel1.setPrice(hotel.getPrice());
        hotel1.setImg(hotel.getImg());
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
    @Override
    public int insert(Hotel hotel){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(hotel);
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
}
