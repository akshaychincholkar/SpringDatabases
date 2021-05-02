package com.game.database.springdb;

import com.game.database.springdb.entity.Address;
import com.game.database.springdb.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringHibernateWithSession implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateWithSession.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

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


        session = sessionFactory.openSession();
        //hql example
        String hqlquery = "from Address ";
        Query query = session.createQuery(hqlquery);
        List<Address> list = query.list();
        System.out.println(list);

        session.close();

        //level 1 cache
/*        session = sessionFactory.openSession();
        Address address1= session.get(Address.class,2);
        System.out.println(address1);
        Address address3= session.get(Address.class,2);
        System.out.println(address3);
        System.out.println("****Server is running*****");*/

        Session session2 = sessionFactory.openSession();
        Address address4= session2.get(Address.class,2);
        System.out.println(address4);
        session2.close();

        Session session3 = sessionFactory.openSession();
        Address address5= session3.get(Address.class,2);
        System.out.println(address5);
        session3.close();
    }

}

