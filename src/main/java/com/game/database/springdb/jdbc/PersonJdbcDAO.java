package com.game.database.springdb.jdbc;

import com.game.database.springdb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PersonJdbcDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person table
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
    }

    public Person findById(int id) {
        Person person = jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findPersonsByCity(String city) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from person where location=?", new Object[]{city},
                new int[]{Types.VARCHAR}); //object and the type is being matching while fetching the data form the database
        List<Person> personList = new ArrayList<Person>();
        for (Map<String, Object> map : maps) {
            personList.add(new Person((int) map.get("ID"), (String) map.get("NAME"), (String) map.get("LOCATION"), (Date) map.get("BIRTH_DATE")));
        }

        return personList;
    }
}
