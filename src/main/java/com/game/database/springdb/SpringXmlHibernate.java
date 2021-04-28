package com.game.database.springdb;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SpringXmlHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    }

}
