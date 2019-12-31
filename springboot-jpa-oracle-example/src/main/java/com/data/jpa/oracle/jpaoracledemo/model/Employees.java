package com.data.jpa.oracle.jpaoracledemo.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Employees {

    // "employee_seq" is Oracle sequence name.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPL_SEQ")
    @SequenceGenerator(sequenceName = "employee_seq", allocationSize = 1, name = "EMPL_SEQ")
    Long id;

    String first_name;

    String email;

    @Column(name = "HIRE_DATE")
    Date date;

    //getters and setters, contructors

}
