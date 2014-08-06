package com.vz.jpa.daoInterfaces;

import com.vz.jpa.entities.*;

import java.util.Date;
import java.util.List;

/**
 * Created by SU on 16.07.2014.
 */
public interface ToursDao {
    List<Tour> selectAllTours();
    Tour selectById(int tours_id);
   public List<Tour> selectToursByParam (/*Date start_date, Date end_date*/ 
    		Country end_Country, City end_City, Hotel hotel_id, Double price1, Double price2, 
    		Integer hot_tour, Integer stars, String type_of_hotel_room, Integer people);
    
    		int update(Tour tour);
    int insert(Tour tour);
	/*List<Tour> selectToursByParam(Integer end_Country, Integer end_City,
			Integer hotel_id, Double price1, Double price2, Integer hot_tour,
			Integer stars, String type_of_hotel_room, Integer people);
*/
}
