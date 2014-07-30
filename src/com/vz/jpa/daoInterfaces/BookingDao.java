package com.vz.jpa.daoInterfaces;


import java.util.List;
import com.vz.jpa.entities.*;


public interface BookingDao {
    List<Booking> selectAll();
    Booking selectById(int id);
    int update(Booking booking);
    int insert(Booking booking);
}
