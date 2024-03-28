package com.example.restapi.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public void registerEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/csv")
    public ResponseEntity<byte[]> getAllEmployeesCsv() throws IOException {
        List<Employee> employees = employeeService.getEmployees();

        String csvContent = convertEmployeesToCSV(employees);
        byte[] csvBytes = csvContent.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("employees.csv").build());
        headers.setContentType(MediaType.parseMediaType("text/csv"));

        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
    }

    private String convertEmployeesToCSV(List<Employee> employees) {
        StringBuilder builder = new StringBuilder();
        // Definiowanie nagłówków
        builder.append("ID,Imię,Nazwisko,Stan Zatrudnienia,Rok Urodzenia,Wynagrodzenie\n");


        for (Employee employee : employees) {
            // Dodawanie danych pracownika
            builder.append(employee.getId()).append(",");
            builder.append(employee.getImie()).append(",");
            builder.append(employee.getNazwisko()).append(",");
            builder.append(employee.getEmployeeCondition()).append(",");
            builder.append(employee.getRokUrodzenia()).append(",");
            builder.append(employee.getWynagrodzenie()).append("\n");
        }

        return builder.toString();
    }


    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId
        );
    }
}
