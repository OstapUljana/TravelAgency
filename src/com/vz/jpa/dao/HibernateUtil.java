package com.vz.jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Женя on 16.07.2014.
 */
public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory = null;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("MySqlManager");
    }

    private HibernateUtil() {
    }

    public static EntityManagerFactory buildEntityManagerFactory() {
        return entityManagerFactory;
    }
}

