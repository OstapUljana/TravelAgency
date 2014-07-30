package com.vz.jpa.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.vz.jpa.entities.*;
import com.vz.jpa.dao.*;

@Path("/updatetour")
public class UpdateToursClass {
	
	
	@POST()
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("text/plain")
	public Response updateTours(@FormParam("tour_name") String tour_name, 
			@FormParam("tour_length")Integer tour_length, 
			@FormParam("transport_id")Integer transport_id,
			
			@FormParam("start_date") String start_date, 
			@FormParam("start_Country")Integer  start_Country,
			@FormParam("start_City") Integer start_City,
			
			@FormParam("end_date") String end_date, 
			@FormParam("end_Country") Integer end_Country, 			
			@FormParam("end_City") Integer end_City, 
			
			@FormParam("hotel_id") Integer hotel_id,
			@FormParam("price") Double price,	
			@FormParam("description") String description,
			@FormParam("hot_tour")  Integer hot_tour) throws ParseException {
		
	
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");//dd.mm.yyyy
        Date sDate = format.parse(start_date);
        Date eDate = format.parse(end_date);
        
		TransportDaoImpl enterTransport = new TransportDaoImpl();
		CountryDaoImpl enterCountry = new CountryDaoImpl();
		CityDaoImpl enterCity = new CityDaoImpl();
		HotelDaoImpl enterHotel = new HotelDaoImpl();
		

		Tour tour = new Tour(tour_name, tour_length,
				sDate, eDate, price, description, 
				hot_tour, enterTransport.selectById(transport_id), 
				enterCountry.selectById(start_Country), enterCity.selectById(start_City),
				enterHotel.selectById(hotel_id),
				enterCountry.selectById(end_Country), enterCity.selectById(end_City));
				
		ToursDaoImpl enterTour = new ToursDaoImpl();
		enterTour.update(tour);	

		return (Response.ok(enterTour).status(200).build()/*.getEntity().toString()*/);
		
	}
}