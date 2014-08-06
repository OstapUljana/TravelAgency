package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.*;
import com.vz.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;

/**
 * Created by SU on 16.07.2014.
 */
public class ToursDaoImpl implements ToursDao {

	private static EntityManagerFactory entityManagerFactory = HibernateUtil
			.buildEntityManagerFactory();

	@Override
	public List<Tour> selectAllTours() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Query query = entityManager.createQuery("SELECT t FROM Tour t");
		List<Tour> tourses = query.getResultList();
		entityManager.close();
		return tourses;
	}

	@Override
	public List<Tour> selectToursByParam(/* Date start_date, Date end_date */
	Country end_Country, City end_City, Hotel hotel_id, Double price1,
			Double price2, Integer hot_tour, Integer stars,
			String type_of_hotel_room, Integer people) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		TypedQuery<Tour> query = entityManager.createQuery(/*"SELECT t, h "*/
				"SELECT t "
				+ "FROM Tour t "
				+ "JOIN t.hotelByHotelId h "
				+ "WHERE "
				// + "t.startDate <= :start_date "
				// + "AND t.endDate > :end_date "
				// + "AND "
				+ "t.countryByEndCountry = :end_Country "
				+ "AND t.cityByEndCity = :end_City "
				+ "AND t.hotelByHotelId = :hotel_id "
				+ "AND t.price >= :price1 " + "AND t.price <= :price2 "
				+ "AND t.hotTour = :hot_tour " + "AND h.stars >= :stars "
				// + "AND h.typeOfHotelRoom = :type_of_hotel_room "
				+ "AND h.people >= :people", Tour.class);

		// query.setParameter("start_date", start_date);
		// query.setParameter("end_date", end_date);
		query.setParameter("end_Country", end_Country);
		query.setParameter("end_City", end_City);
		query.setParameter("hotel_id", hotel_id);
		query.setParameter("price1", price1);
		query.setParameter("price2", price2);
		query.setParameter("hot_tour", hot_tour);
		query.setParameter("stars", stars);
		// query.setParameter("type_of_hotel_room", type_of_hotel_room);
		query.setParameter("people", people);
		List<Tour> tourses =query.getResultList();
		entityManager.close();
		return tourses;
	}

	@Override
	public Tour selectById(int tours_id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Query query = entityManager
				.createQuery("SELECT t FROM Tour t WHERE t.Tour_id = :t_id");
		query.setParameter("t_id", tours_id);
		Tour tours = (Tour) query.getSingleResult();
		entityManager.close();
		return tours;
	}

	@Override
	public int update(Tour tour) {
		// one entity manager serving only its own objects
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Tour tour1 = (Tour) entityManager.find(Tour.class, tour.getTourId());
		if (tour1 == null) {
			return 0;
		}
		entityManager.getTransaction().begin();
		tour1.setTourName(tour.getTourName());
		tour1.setTourLength(tour.getTourLength());
		//tour1.setTransportByTransportId(tour.getTransportByTransportId());

		tour1.setStartDate(tour.getStartDate());
		tour1.setCountryByStartCountry(tour.getCountryByStartCountry());
		tour1.setCityByStartCity(tour.getCityByStartCity());

		tour1.setEndDate(tour.getEndDate());
		tour1.setCountryByEndCountry(tour.getCountryByEndCountry());
		tour1.setCityByEndCity(tour.getCityByEndCity());

		tour1.setHotelByHotelId(tour.getHotelByHotelId());
		tour1.setPrice(tour.getPrice());
		tour1.setDescription(tour.getDescription());
		tour1.setHotTour(tour.getHotTour());
		entityManager.getTransaction().commit();
		entityManager.close();
		return 1;

	}

	@Override
	public int insert(Tour tour) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(tour);
		entityManager.getTransaction().commit();
		entityManager.close();
		return 1;
	}
}
