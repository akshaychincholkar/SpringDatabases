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
        Address address3 = new Address(3,"Stree3","Akola",true,21.21,new Date(),data);
        Address address4 = new Address(4,"Stree4","Amravati",true,21.21,new Date(),data);

        Set addresses = new HashSet<>();
//        List addresses = new ArrayList<Address>();
        addresses.add(address);
        addresses.add(address2);
        addresses.add(address3);
        addresses.add(address4);
        Student student1=new Student(1,"Akshay","Amravati",addresses);
        System.out.println(student1);

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(address);
        session.save(address2);
        session.save(address3);
        session.save(address4);
        session.save(student1);
        tx.commit();
        session.close();


        session = sessionFactory.openSession();
        //hql example
        String city = "Amravati";
//        get data
        String getQuery = "from Address where city=:city";
        Query query = session.createQuery(getQuery);
        query.setParameter("city",city);
        List<Address> list = query.list();
        System.out.println(list);

        System.out.println("---------------------------------------------------");
//        delete
        city = "Delhi";
        String deleteQuery = "delete from Address where city=:city";
        tx = session.beginTransaction();
        query = session.createQuery(deleteQuery);
        query.setParameter("city",city);
        int r = query.executeUpdate();
        System.out.println("Total : "+r);
        tx.commit();

//        update
        city = "Amravati";
        String street = "Random street";
        String updateQuery = "update Address set street =:street where city=:city";
        tx = session.beginTransaction();
        query = session.createQuery(updateQuery);
        query.setParameter("city",city);
        query.setParameter("street",street);
        r = query.executeUpdate();
        System.out.println("Rows updated: "+r);
        tx.commit();

//        Join
        String joinQuery = "select s.id,a.addressId from Student as s INNER JOIN s.children as a";
        query = session.createQuery(joinQuery);
        List list1 =query.getResultList();
        for(Object element: list1)
        System.out.println((Address)element);

        session.close();
        //level 1 cache
/*        session = sessionFactory.openSession();
        Address address1= session.get(Address.class,2);
        System.out.println(address1);
        Address address3= session.get(Address.class,2);
        System.out.println(address3);
        System.out.println("****Server is running*****");*/

//      level 2 cache
        Session session2 = sessionFactory.openSession();
        Address address5= session2.get(Address.class,1);
        System.out.println(address5);
        session2.close();

        Session session3 = sessionFactory.openSession();
        Address address6= session3.get(Address.class,1);
        System.out.println(address6);
        session3.close();
    }

}

