package com.game.database.springdb;

import com.game.database.springdb.entity.Address;
import com.game.database.springdb.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class SpringXmlHibernate {
    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println(sessionFactory);
        System.out.println("is closed: "+sessionFactory.isClosed());

        FileInputStream fileInputStream = new FileInputStream("H:\\workspace\\Neon\\spring-db\\src\\main\\resources\\pic.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read();
        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);
        Address address2 = new Address(2,"Stree2","Amravati",true,21.21,new Date(),data);

        Set addresses = new HashSet<>();
//        List addresses = new ArrayList<Address>();
        addresses.add(address);
        addresses.add(address2);
        Student student1=new Student(1,"Akshay","Amravati",addresses);
        System.out.println(student1);

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(address);
        session.save(address2);
        session.save(student1);
        tx.commit();
        session.close();

        System.out.println("waiting to finish..");
    }

}
