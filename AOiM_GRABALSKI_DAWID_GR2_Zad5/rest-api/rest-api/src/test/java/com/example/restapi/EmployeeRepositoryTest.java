package com.example.restapi;

import com.example.restapi.emp.Employee;
import com.example.restapi.emp.EmployeeCondition;
import com.example.restapi.emp.EmployeeRepository;
import com.example.restapi.group.GroupEmployee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void EmployeeRepository_SaveAll_ReturnSavedEmployee() {
        // Arrange
        GroupEmployee group = new GroupEmployee("grp1", 5);
        Employee employee = new Employee("Jan", "Kowalski", EmployeeCondition.OBECNY, 3000, 2000, group);

        // Ustaw pozostałe wymagane pola dla Employee

        // Act
        Employee savedEmployee = employeeRepository.save(employee);

        // Assert
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isNotNull();
        assertThat(savedEmployee.getImie()).isEqualTo("Jan");

    }
}
