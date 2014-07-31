package com.vz.jpa.facade;

import java.util.*;
import javax.ws.rs.*;
import com.vz.jpa.dao.ToursDaoImpl;
import com.vz.jpa.entities.Country;
import com.vz.jpa.entities.Hotel;
import com.vz.jpa.entities.Tour;

/**
 * @author NikichXP
 * @version 1.1
 */
@Path ("/search")
public class SearchFilter {

	public final static int counriesCount = 50;
	public final static int hotelsCount = 50;
	
	@GET
	@Path("/ping")
	@Produces("text/plain")
	public String sayHello() {
		return "Hello world!";
	}
	
	/**
	 * 
	 * @param params
	 *            - параметры поиска, шаблоны: price:1000-20000
	 *            startcountry:5,6,12,14 endcountry:1,3,4,5 hotels:1,2,5,7
	 *            length:5-15, date:before-15.04.2015 или date:later-25.03.2014
	 *            или date:later-25.03.2014+before-15.04.2015 
	 * @return Фильтрованный список
	 */
	@GET
	@Path("/tour")
	@Produces("application/xml")
	public static ArrayList<Tour> getFilteredTourListFromDB (String [] params) {
		ToursDaoImpl getter = new ToursDaoImpl();
				
		String[] filter = {"price:10-20000", "before:15.05.8999"};
		List<Tour> gt = getter.selectAllTours();
		ArrayList<Tour> ret = new ArrayList<Tour>();
		for (int i = 0; i < gt.size(); i++) {
			ret.add(new Tour());
			if (gt.get(i).getPrice() == null) 
				System.out.println("null");
			else
				System.out.println("nice");
			ret.get(i).setPrice(gt.get(i).getPrice());
			if (gt.get(i).getHotelByHotelId() == null) 
				System.out.println("null");
			else
				System.out.println("nice");
			ret.get(i).setHotelByHotelId(gt.get(i).getHotelByHotelId());
			if (gt.get(i).getCountryByStartCountry() == null) 
				System.out.println("null");
			else
				System.out.println("nice");
			ret.get(i).setCountryByStartCountry(gt.get(i).getCountryByStartCountry());
			if (gt.get(i).getCountryByEndCountry() == null) 
				System.out.println("null");
			else
				System.out.println("nice");
			ret.get(i).setCountryByEndCountry(gt.get(i).getCountryByEndCountry());
			if (gt.get(i).getStartDate() == null) 
				System.out.println("null");
			else
				System.out.println("nice");
			ret.get(i).setStartDate(gt.get(i).getStartDate());
			if (gt.get(i).getEndDate() == null)
				System.out.println("null");else
					System.out.println("nice");
			
			ret.get(i).setEndDate(gt.get(i).getEndDate());
		}

		return findTour(filter, ret);
		
	}
	
	@GET
	@Path("/all")
	@Produces("application/xml")
	public static ArrayList<Tour> planB () {
		String[] filter = {"price:1500-20000", "before:15.07.2014"};
		Date d1, d2, d3;
		d1 = new Date(2014 - 1900, 5, 15);
		d2 = new Date(2014 - 1900, 5, 20); // 5 days
		d3 = new Date(2014 - 1900, 6, 20); // month+5 days
		Tour tour1 = new Tour(), tour2 = new Tour(), tour3 = new Tour();
		Country c = new Country();
		Hotel h = new Hotel();
		h.setHotelId(1);
		c.setCountryId(1);
		tour1.setHotelByHotelId(h);
		tour2.setHotelByHotelId(h);
		tour3.setHotelByHotelId(h);
		tour1.setCountryByEndCountry(c);
		tour2.setCountryByEndCountry(c);
		tour3.setCountryByEndCountry(c);
		tour1.setCountryByStartCountry(c);
		tour2.setCountryByStartCountry(c);
		tour3.setCountryByStartCountry(c);
		tour1.setPrice(1800.0);
		tour2.setPrice(1200.0);
		tour3.setPrice(1800.0);
		tour1.setStartDate(d1);
		tour1.setEndDate(d2);
		tour2.setStartDate(d1);
		tour2.setEndDate(d3);
		tour3.setStartDate(d2);
		tour3.setEndDate(d3);
		ArrayList<Tour> test = new ArrayList<Tour>();
		test.add(tour1);
		test.add(tour2);
		test.add(tour3);
		
		return findTour(filter, test);
	}

	/**
	 * 
	 * @param params
	 *            - параметры поиска, шаблоны: price:1000-20000
	 *            startcountry:5,6,12,14 endcountry:1,3,4,5 hotels:1,2,5,7
	 *            length:5-15, date:before-15.04.2015 или date:later-25.03.2014
	 *            или date:later-25.03.2014+before-15.04.2015
	 * @return Список туров в виде ArrayList
	 */
	public static ArrayList<Tour> findTour(String[] params, ArrayList<Tour> test) {

		// Базовые фильтры
		int minPrice = 0, maxPrice = Integer.MAX_VALUE;
		long minLength = 0, maxLength = Integer.MAX_VALUE;

		boolean[] endCountryFlags = new boolean[counriesCount];
		boolean[] startCountryFlags = new boolean[counriesCount];
		boolean[] hotelFlags = new boolean[hotelsCount];
		boolean isBeginDateUsed = false, isEndDateUsed = false, isStartCountrySelected = false, isEndCountrySelected = false, isHotelsSelected = false;

		GregorianCalendar beginDate = null, endDate = null;
		String temp[], tmp[], tmp2[];

		for (String param : params) {
			temp = param.split("[:]");
			switch (temp[0]) {
			case "date":
				tmp = temp[1].split("[+-]");
				for (int i = 0; i < tmp.length; i = i + 2) {
					switch (tmp[i]) {
					case "before":
						tmp2 = tmp[i + 1].split("[.]");
						endDate = new GregorianCalendar(
								Integer.parseInt(tmp2[2]),
								Integer.parseInt(tmp2[1]) - 1,
								Integer.parseInt(tmp2[0]));
						isEndDateUsed = true;
						break;
					case "after":
						tmp2 = tmp[i + 1].split("[.]");
						beginDate = new GregorianCalendar(
								Integer.parseInt(tmp2[2]),
								Integer.parseInt(tmp2[1]) - 1,
								Integer.parseInt(tmp2[0]));
						isBeginDateUsed = true;
						break;
					}
				}
				break;
			case "price":
				tmp = temp[1].split("[-]");
				minPrice = Integer.parseInt(tmp[0]);
				maxPrice = Integer.parseInt(tmp[1]);
				break;
			case "length":
				tmp = temp[1].split("[-]");
				minLength = Integer.parseInt(tmp[0]);
				maxLength = Integer.parseInt(tmp[1]);
				break;
			case "startcountry":
				tmp = temp[1].split("[,]");
				for (String select : tmp)
					startCountryFlags[Integer.parseInt(select)] = true;
				isStartCountrySelected = true;
				break;
			case "endcountry":
				tmp = temp[1].split("[,]");
				for (String select : tmp)
					endCountryFlags[Integer.parseInt(select)] = true;
				isEndCountrySelected = true;
				break;
			case "hotels":
				tmp = temp[1].split("[,]");
				for (String select : tmp)
					hotelFlags[Integer.parseInt(select)] = true;
				isHotelsSelected = true;
				break;
			}
		}
		if (!isBeginDateUsed)
			beginDate = new GregorianCalendar(1, 1, 1);
		if (!isEndDateUsed)
			endDate = new GregorianCalendar(3987, 12, 12);
		if (!isStartCountrySelected)
			for (int i = 0; i < startCountryFlags.length; i++)
				startCountryFlags[i] = true;
		if (!isEndCountrySelected)
			for (int i = 0; i < endCountryFlags.length; i++)
				endCountryFlags[i] = true;
		if (!isHotelsSelected)
			for (int i = 0; i < hotelFlags.length; i++)
				hotelFlags[i] = true;

		ArrayList<Tour> ret = new ArrayList<Tour>();
		List<Tour> list = test;
		Iterator<Tour> it = list.listIterator();
		Tour tour;
		long tmplong;
		while (it.hasNext()) {
			tour = it.next();
			tmplong =  ((tour.getEndDate().getTime() - tour.getStartDate().getTime())/(1000*3600*24));
			if (
					tour.getPrice() < maxPrice
					& tour.getPrice() > minPrice
					& startCountryFlags[tour.getCountryByStartCountry().getCountryId()]
					& endCountryFlags[tour.getCountryByEndCountry().getCountryId()]
					& hotelFlags[tour.getHotelByHotelId().getHotelId()]
					& endDate.getTime().getTime()
							- tour.getEndDate().getTime() > 0
					& beginDate.getTime().getTime()
							- tour.getStartDate().getTime() < 0
					& tmplong < maxLength
					& tmplong > minLength
				){
					ret.add(tour);
			}
		}
		return ret;
	}
	
	public static ArrayList<Hotel> filterHotel (String [] params, ArrayList<Hotel> list) {
		ArrayList <Hotel> ret = new ArrayList<Hotel>();
		int minStars = 1, maxStars = 5, minRating = 0, maxRating = 100;
		double minPrice = 0, maxPrice = Double.MAX_VALUE;
		boolean [] roomType = new boolean [4]; //econom, family, business, lux
 
		boolean typeSelected = false;
		
		String [] temp, temp1;
		for (String param : params) {
			temp = param.split("[:]");
			switch (temp[0]) {
			case "stars": 
				temp1 = temp[1].split("[-]");
				minStars = Integer.parseInt(temp1[0]);
				maxStars = Integer.parseInt(temp1[1]);
				if (minStars > maxStars) {
					int tempint;
					tempint = minStars;
					minStars = maxStars;
					maxStars = tempint;
				}
				break;
			case "price":
				temp1 = temp[1].split("[-]");
				minPrice = Double.parseDouble(temp1[0]);
				maxPrice = Double.parseDouble(temp1[1]);
				break;
			case "rating":
				temp1 = temp[1].split("[-]");
				minRating = Integer.parseInt(temp1[0]);
				maxRating = Integer.parseInt(temp1[1]);
				if (minRating > maxRating) {
					int tempint;
					tempint = minRating;
					minRating = maxRating;
					maxRating = tempint;
				}
				break;
			case "type":
				typeSelected = true;
				temp1 = temp[1].split("[,]");
				for (String type : temp1) {
					switch (type) {
					case "eco":
					case "economy":
					case "econom":
						roomType[0] = true;
						break;
					case "family":
						roomType[1] = true;
						break;
					case "business":
					case "middle":
						roomType[2] = true;
						break;
					case "lux":
						roomType[3] = true;
						break;
						default: 
							System.out.println("Неподдерживаемый тип комнаты в поиске отеля.");
					}
				}
				typeSelected = true;
				break;
			default:
				System.out.println("Unsupported feature");
			}
		}
		if (!typeSelected) {
			for (int i = 0; i < roomType.length; i++) {
				roomType[i] = true;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (roomType[i] == true & 
					list.get(i).getStars() > minStars &
					list.get(i).getStars() < maxStars &
					list.get(i).getPrice() > minPrice &
					list.get(i).getPrice() < maxPrice &
					list.get(i).getRating() > minRating &
					list.get(i).getRating() < maxRating
			) {
				ret.add(list.get(i));
			}
		}
		return ret;
	}
}
