package com.game.database.springdb;

import com.game.database.springdb.entity.Address;
import com.game.database.springdb.entity.Student;
import com.game.database.springdb.jpa.AddressRepository;
import com.game.database.springdb.jpa.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileInputStream;
import java.util.*;

@SpringBootApplication
@ComponentScan("com.game.database.springdb.jpa")
public class SpringHibernateMapping implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateMapping.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------Hibernate -------");
        FileInputStream fileInputStream = new FileInputStream("H:\\workspace\\Neon\\spring-db\\src\\main\\resources\\pic.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read();

//        1-1
/*        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);
        studentRepository.save(new Student(1,"Akshay","Amravati",address));*/
//        1-many with FTC
/*        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);
        Address address2 = new Address(2,"Stree2","Amravati",true,21.21,new Date(),data);

        Set addresses = new HashSet<>();
//        List addresses = new ArrayList<Address>();
        addresses.add(address);
        addresses.add(address2);

        studentRepository.save(new Student(1,"Akshay","Amravati",addresses));*/
//      1-Many without ftc
/*        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);
        Address address2 = new Address(2,"Stree2","Amravati",true,21.21,new Date(),data);
        addressRepository.save(address);
        addressRepository.save(address2);

        Student student = new Student(1,"Akshay","Amravati");
        address.setStudent(student);
        address2.setStudent(student);
//        Set addresses = new HashSet<>();
        List addresses = new ArrayList<Address>();
        addresses.add(address);
        addresses.add(address2);

        student.setAddress(addresses);
        studentRepository.save(student);*/
//      many - 1 without FTC
/*        Student student1=new Student(1,"Akshay","Amravati");
        Student student2=new Student(2,"Darshana","Amravati");

        studentRepository.save(student1);
        studentRepository.save(student2);

        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);
        List students = new ArrayList();
        students.add(student1);
        students.add(student2);
        address.setChildren(students);
        addressRepository.save(address);*/
//        many-1
/*        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);
        Student student1=new Student(1,"Akshay","Amravati",address);
        Student student2=new Student(2,"Darshana","Amravati",address);

        studentRepository.save(student1);
        studentRepository.save(student2);*/

//        many-many
/*        Address address1 = new Address(1,"Street1","Delhi",true,21.21,new Date(),data);
        Address address2 = new Address(2,"Street2","Amravati",true,21.21,new Date(),data);

        Student student1=new Student(1,"Akshay","Amravati");
        Student student2=new Student(2,"Darshana","Amravati");

        Set addresses = new HashSet();
        addresses.add(address1);
        addresses.add(address2);

//        Set students  = new HashSet();
//        students.add(student1);
//        students.add(student2);

        student1.setAddress(addresses);
        student2.setAddress(addresses);

        studentRepository.save(student1);
//        studentRepository.save(student2);*/

    }
}
