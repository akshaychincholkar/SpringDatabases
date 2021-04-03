package com.game.database.springdb.jdbc;

import com.game.database.springdb.entity.PersonJdbc;
import com.game.database.springdb.entity.PersonJdbc;
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

    class PersonJdbcRowMapper implements RowMapper<PersonJdbc> {

        @Override
        public PersonJdbc mapRow(ResultSet resultSet, int i) throws SQLException {
            PersonJdbc PersonJdbc = new PersonJdbc();
            PersonJdbc.setId(resultSet.getInt("id"));
            PersonJdbc.setName(resultSet.getString("name"));
            PersonJdbc.setLocation(resultSet.getString("location"));
            PersonJdbc.setBirthDate(resultSet.getTimestamp("birth_date"));
            return PersonJdbc;
        }
    }
    //select * from Person table
    public List<PersonJdbc> findAll() {
        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper(PersonJdbc.class));
    }
    public List<PersonJdbc> findAllByRowMapper() {
        return jdbcTemplate.query("select * from Person", new PersonJdbcRowMapper());
    }

    public PersonJdbc findById(int id) {
        return jdbcTemplate.queryForObject("select * from Person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<PersonJdbc>(PersonJdbc.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Person where id=?",
                new Object[]{id});
    }

    public int insert(PersonJdbc PersonJdbc) {
        return jdbcTemplate.update("" +
                        "INSERT INTO Person (ID, NAME, LOCATION, BIRTH_DATE )" +
                        "VALUES(?, ?, ?,?)",
                new Object[]{PersonJdbc.getId(), PersonJdbc.getName(), PersonJdbc.getLocation(), new Timestamp(PersonJdbc.getBirthDate().getTime())});
    }

    public int update(PersonJdbc PersonJdbc) {
        return jdbcTemplate.update("" +
                        "update Person " +
                        "set name=?, location=?, birth_date = ?" +
                        "where id = ?",
                new Object[]{PersonJdbc.getName(), PersonJdbc.getLocation(), new Timestamp(PersonJdbc.getBirthDate().getTime()),PersonJdbc.getId()});
    }

    public List<PersonJdbc> findPersonByCity(String city) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from Person where location=?", new Object[]{city},
                new int[]{Types.VARCHAR}); //object and the type is being matching while fetching the data form the database
        List<PersonJdbc> PersonJdbcList = new ArrayList<PersonJdbc>();
        for (Map<String, Object> map : maps) {
            PersonJdbcList.add(new PersonJdbc((int) map.get("ID"), (String) map.get("NAME"), (String) map.get("LOCATION"), (Date) map.get("BIRTH_DATE")));
        }

        return PersonJdbcList;
    }
}
