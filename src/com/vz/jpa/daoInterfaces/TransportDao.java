package com.vz.jpa.daoInterfaces;

import com.vz.jpa.entities.*;
import java.util.List;

/**
 * Created by SU on 16.07.2014.
 */
public interface TransportDao {
    List<Transport> selectAll();
    Transport selectById(int id);
    int update(Transport transport);
    int insert(Transport transport);
}
