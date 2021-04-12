package com.game.database.springdb.jpa;

import com.game.database.springdb.entity.Address;
import com.game.database.springdb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
