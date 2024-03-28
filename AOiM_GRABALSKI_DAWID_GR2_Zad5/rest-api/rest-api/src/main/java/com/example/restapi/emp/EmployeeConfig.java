package com.example.restapi.emp;

import com.example.restapi.group.GroupEmployee;
import com.example.restapi.group.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, GroupRepository groupRepository){

        return args -> {
            GroupEmployee exampleGroup = new GroupEmployee("group1", 10);
            groupRepository.save(exampleGroup);

            Employee Dawid = new Employee(
                    "Dawid",
                    "Grabalski",
                    EmployeeCondition.OBECNY,
                    2002,
                    5000,
                    exampleGroup

            );

            Employee Michal = new Employee(
                    "Michal",
                    "Kmak",
                    EmployeeCondition.OBECNY,
                    2002,
                    5000,
                    exampleGroup
            );

            Employee Patrycja = new Employee(
                    "Patrycja",
                    "Jablonska",
                    EmployeeCondition.OBECNY,
                    2002,
                    5000,
                    exampleGroup
            );



            employeeRepository.saveAll(List.of(Dawid, Patrycja, Michal));

        };
    }

}

