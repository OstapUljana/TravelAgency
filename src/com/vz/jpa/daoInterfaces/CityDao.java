package com.vz.jpa.daoInterfaces;

import com.vz.jpa.entities.*;

import java.util.List;

/**
 * Created by SU on 16.07.2014.
 */
public interface CityDao {
    List<City> selectAll();
    City selectById(int id);

    int update(City city);
    int insert(City city);
}
