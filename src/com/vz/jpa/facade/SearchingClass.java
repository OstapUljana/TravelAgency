package com.vz.jpa.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vz.jpa.entities.*;
import com.vz.jpa.dao.*;

@Path("/searching")
public class SearchingClass {

	@POST()
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	//@Produces("text/plain")
	public Response searchingTours(@FormParam("start_date") String start_date,
			@FormParam("end_date") String end_date,
			@FormParam("startCountry") int startCountry,
			@FormParam("startCity") int startCity,
			@FormParam("end_Country") int end_Country,
			@FormParam("end_City") int end_City,
			@FormParam("hotel_id") int hotel_id,
			@FormParam("price_1") Double price1,
			@FormParam("price_2") Double price2,
			@FormParam("hot_tour") Integer hot_tour,
			@FormParam("people") Integer people,
			@FormParam("stars") Integer stars,
			@FormParam("type_of_hotel_room") String type_of_hotel_room)
			throws ParseException {

		// SimpleDateFormat format = new
		// SimpleDateFormat("dd.mm.yyyy");//dd.mm.yyyy
		// Date sDate = format.parse(start_date);
		// Date eDate = format.parse(end_date);
		// System.out.print(sDate);

		CountryDaoImpl enterCountry = new CountryDaoImpl();
		CityDaoImpl enterCity = new CityDaoImpl();
		HotelDaoImpl enterHotel = new HotelDaoImpl();

		ToursDaoImpl enterTour = new ToursDaoImpl();
		List<Tour> ansver = enterTour.selectToursByParam(
				/* sDate, eDate, */enterCountry.selectById(end_Country),
				enterCity.selectById(end_City),
				enterHotel.selectById(hotel_id), price1, price2, hot_tour,
				stars, type_of_hotel_room, people);

		AnsverListClass ansverObject = new AnsverListClass(ansver);
		for(Tour t:ansverObject.tourList){
			System.out.println(t);
		}
		System.out.println(ansver.isEmpty());
		System.out.println(ansver);
		return Response.ok(ansverObject).build()// .getEntity().toString()
		;
	}
}
