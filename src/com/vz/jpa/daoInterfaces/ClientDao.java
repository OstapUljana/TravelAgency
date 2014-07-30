package com.vz.jpa.daoInterfaces;

import com.vz.jpa.entities.*;

import java.util.List;

/**
 * Created by SU on 16.07.2014.
 */
public interface ClientDao {
    List<Client> selectAll();
    Client selectById(int id);
    Client selectByEmailandPassword(String email, String password);
    boolean clientExistCheck(String email, String password);
    // List<Client> selectByEmailandPassword(String email, String password);
    boolean selectByEmail(String email);
    int update(Client client);
    Client insert(Client client);
}
