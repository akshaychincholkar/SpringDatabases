package com.game.database.springdb;

import com.game.database.springdb.entity.Address;
import com.game.database.springdb.entity.Student;
import com.game.database.springdb.jpa.AddressRepository;
import com.game.database.springdb.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileInputStream;
import java.util.Date;

@SpringBootApplication
@ComponentScan("com.game.database.springdb.jpa")
public class SpringHibernateApplication implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------Hibernate -------");
        FileInputStream fileInputStream = new FileInputStream("H:\\workspace\\Neon\\spring-db\\src\\main\\resources\\pic.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read();
        Address address = new Address(1,"Stree1","Delhi",true,21.21,new Date(),data);

        studentRepository.save(new Student(1,"Akshay","Amravati",address));

    }
}
