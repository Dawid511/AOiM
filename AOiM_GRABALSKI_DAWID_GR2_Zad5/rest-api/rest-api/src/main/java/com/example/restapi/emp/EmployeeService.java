package com.example.restapi.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        Optional<Employee> emp = employeeRepository.findEmployee(employee.getImie(), employee.getNazwisko());
        if(emp.isPresent()) {
            throw new IllegalStateException("Taki uzytkownik juz istnieje");
        }else
            employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean existe = employeeRepository.existsById(employeeId);

        if(!existe) {
            throw new IllegalStateException("nie ma takiego pracownika!");
        }else
            employeeRepository.deleteById(employeeId);
    }
}
