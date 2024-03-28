package org.example;

import jakarta.persistence.*;
import java.lang.Comparable;
@Entity
public class Employee implements Comparable<Employee> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    String surname;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    EmployeeCondition empCond;
    int birth;
    double salary;

    @ManyToOne
    @JoinColumn(name = "employeeGroup")
    EmployeeGroup employeeGroup;

    public Employee() {}
    public Employee(String name, String surname, EmployeeCondition empCond, int birth, double salary) {
        this.name = name;
        this.surname = surname;
        this.empCond = empCond;
        this.birth = birth;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee pracownik) {
        return this.surname.compareTo(pracownik.surname);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EmployeeCondition getCndt() {
        return empCond;
    }

    public void setCndt(EmployeeCondition cndt) {
        this.empCond = cndt;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double wage) {
        this.salary = wage;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    void printing() {
        System.out.println("imie: " + name);
        System.out.println("nazwisko: " + surname);
        System.out.println("employeeCondition: " + empCond);
        System.out.println("rok urodzenia: " + birth);
        System.out.println("wynagrodzenie: " + salary);

    }

}
