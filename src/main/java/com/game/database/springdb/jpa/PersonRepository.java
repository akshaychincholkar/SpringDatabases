package com.game.database.springdb.jpa;

import com.game.database.springdb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

//Repository
//Transaction - ACID property maintained - implemented around business services, here we restrict it to repository
//@Repository
//@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer> {

   /* @PersistenceContext
    EntityManager entityManager;//manages all the entities, it is the interface to the persistenceContext

    //connect to the database
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }*/
}
