
package com.data.jpa.oracle.jpaoracledemo;

import com.data.jpa.oracle.jpaoracledemo.dao.EmployeeRepository;
import com.data.jpa.oracle.jpaoracledemo.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import static java.lang.System.exit;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM=dd");

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String ... args) {

        System.out.println("dataSource = " + dataSource);

        System.out.println("\n1.findAll()...");

        System.out.println("\n1.findAll()...");
        for (Employees employee : employeeRepository.findAll()) {
            System.out.println(employee);
        }

        System.out.println("\n2.findByEmail(String email)...");
        for (Employees employee : employeeRepository.findByEmail("222@yahoo.com")) {
            System.out.println(employee);
        }

/*        System.out.println("\n3.findByDate(Date date)...");
        for (Employee employee : employeeRepository.findByDate(sdf.parse("2017-02-12"))) {
            System.out.println(employee);
        }*/

        // For Stream, need @Transactional
        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
        try (Stream<Employees> stream = employeeRepository.findByEmailReturnStream("333@yahoo.com")) {
            stream.forEach(x -> System.out.println(x));
        }

        System.out.println("Done!");

        exit(0);

    }




}
