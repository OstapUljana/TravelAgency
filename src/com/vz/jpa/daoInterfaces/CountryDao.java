package com.vz.jpa.daoInterfaces;

import com.vz.jpa.entities.*;

import java.util.List;

/**
 * Created by User on 15.07.2014.
 */
public interface CountryDao {
    List<Country> selectAllCountry();
    Country selectById(int country_id);

//    List<City> selectAllCityInThisCountry(int country_id);

    int update(Country country);
    int insert(Country country);
}
