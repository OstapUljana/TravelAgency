package com.vz.jpa.daoInterfaces;

import com.vz.jpa.entities.User;

import java.util.List;

/**
 * Created by Женя on 16.07.2014.
 */
public interface UserDao {
    List<User> selectAll();
    //User selectUser(String login, String pass);
    User selectById(int id);
    int update(User user);
    int insert(User user);

}
