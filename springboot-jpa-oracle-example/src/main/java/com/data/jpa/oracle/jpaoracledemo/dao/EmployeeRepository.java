package com.data.jpa.oracle.jpaoracledemo.dao;

import com.data.jpa.oracle.jpaoracledemo.model.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface EmployeeRepository extends CrudRepository<Employees, Long> {

    List<Employees> findByEmail(String email);

    List<Employees> findByDate(Date date);

    // custom query example and return a stream
    @Query("Select e from Employees e where e.email = :email")
    Stream<Employees> findByEmailReturnStream(@Param("email") String email);

}

