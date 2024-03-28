package com.example.springbootrestapi.employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private String imie;
    private String nazwisko;
    private EmployeeCondition employeeCondition;
    private int rokUrodzenia;
    private double wynagrodzenie;

    public Employee(String imie, String nazwisko, EmployeeCondition employeeCondition, int rokUrodzenia, double wynagrodzenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.employeeCondition = employeeCondition;
        this.rokUrodzenia = rokUrodzenia;
        this.wynagrodzenie = wynagrodzenie;
    }


    public Employee() {
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public EmployeeCondition getEmployeeCondition() {
        return employeeCondition;
    }

    public void setEmployeeCondition(EmployeeCondition employeeCondition) {
        this.employeeCondition = employeeCondition;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", employeeCondition=" + employeeCondition +
                ", rokUrodzenia=" + rokUrodzenia +
                ", wynagrodzenie=" + wynagrodzenie +
                '}';
    }
}
