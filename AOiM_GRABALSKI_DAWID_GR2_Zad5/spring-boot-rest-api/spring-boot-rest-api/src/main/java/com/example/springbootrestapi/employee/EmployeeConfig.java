/*
package com.example.springbootrestapi.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee Dawid = new Employee(
                    "Dawid",
                    "Grabalski",
                    EmployeeCondition.OBECNY,
                    2002,
                    5000
            );
            Employee Michal = new Employee(
                    "Michal",
                    "Kmak",
                    EmployeeCondition.OBECNY,
                    2002,
                    5000
            );

            repository.saveAll(
                    List.of(Dawid, Michal)
            );
        };
    }
}
*/
