package com.game.database.springdb.jdbc;

import com.game.database.springdb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PersonJdbcDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }
    //select * from person table
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
    }
    public List<Person> findAllByRowMapper() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?",
                new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("" +
                        "INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )" +
                        "VALUES(?, ?, ?,?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update("" +
                        "update person " +
                        "set name=?, location=?, birth_date = ?" +
                        "where id = ?",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),person.getId()});
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
