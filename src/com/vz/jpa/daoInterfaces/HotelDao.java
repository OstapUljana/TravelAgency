package com.vz.jpa.daoInterfaces;
import com.vz.jpa.entities.*;

import java.util.List;

/**
 * Created by SU on 16.07.2014.
 */
public interface HotelDao {
    List<Hotel> selectAllHotels();
    Hotel selectById(int hotel_id);

    int update(Hotel hotel);
    int insert(Hotel hotel);
}
