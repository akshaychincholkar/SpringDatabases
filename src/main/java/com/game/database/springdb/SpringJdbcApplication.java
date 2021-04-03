package com.game.database.springdb;

import com.game.database.springdb.entity.PersonJdbc;
import com.game.database.springdb.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDAO personJdbcDAO;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users: {}",personJdbcDAO.findAll());
		logger.info("=====================================");
		logger.info("User id 10001 {} ",personJdbcDAO.findById(10001));
		logger.info("User in Amsterdam {} ",personJdbcDAO.findPersonByCity("Amsterdam"));
		if ((personJdbcDAO.deleteById(10004) == 0)) {
			System.out.println("Person not present");
		} else {
			System.out.println("Person deleted");
		}
		logger.info("Inserting 10005 : {}",personJdbcDAO.insert(
				new PersonJdbc(10005,"Tara","Berlin",new Date())));
		logger.info("Updating 10003 : {}",personJdbcDAO.update(
				new PersonJdbc(10003,"Peter","Utrecht",new Date())));

	}
}
