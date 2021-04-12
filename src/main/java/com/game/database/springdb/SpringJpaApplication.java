package com.game.database.springdb;

import com.game.database.springdb.entity.Person;
import com.game.database.springdb.jpa.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;

//@SpringBootApplication
@ComponentScan("com.game.database.springdb.jpa")
public class SpringJpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("=====================================");
		logger.info("User id 10001 {} ",repository.findById(10001));

		logger.info("Inserted the Person named: Darshana");
		repository.save(new Person("Darshana","Amravati",new Date()));
		logger.info("Person with Id 1:{}",repository.findById(1));
		logger.info("Deleted Person with id 10002");
		repository.deleteById(10002);
		repository.save(new Person(1,"Darshana","Amravati",new SimpleDateFormat("dd-MM-yyyy").parse("27-03-1994")));//new SimpleDateFormat("yyyy-MM-dd").parse("27-03-1994")
        logger.info("Person with name Darshana is updated with birthdate as ");
		/*logger.info("User in Amsterdam {} ",repository.findPersonsByCity("Amsterdam"));
		if ((repository.deleteById(10004) == 0)) {
			System.out.println("Person not present");
		} else {
			System.out.println("Person deleted");
		}
		logger.info("Inserting 10005 : {}",repository.insert(
				new Person(10005,"Tara","Berlin",new Date())));
		logger.info("Updating 10003 : {}",repository.update(
				new Person(10003,"Peter","Utrecht",new Date())));
*/
	}
}
