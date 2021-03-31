package com.game.database.springdb;

import com.game.database.springdb.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDbApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDAO personJdbcDAO;
	public static void main(String[] args) {
		SpringApplication.run(SpringDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users: {}",personJdbcDAO.findAll());
		logger.info("=====================================");
		logger.info("User id 10001 {} ",personJdbcDAO.findById(10001));
		logger.info("User in Amsterdam {} ",personJdbcDAO.findPersonsByCity("Amsterdam"));
	}
}
