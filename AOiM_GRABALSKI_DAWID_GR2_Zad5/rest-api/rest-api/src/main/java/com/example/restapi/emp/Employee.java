package com.example.restapi.emp;


import com.example.restapi.group.GroupEmployee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

@Entity
@Table(name = "employees" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"imie", "nazwisko"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="imie")
    private String imie;
    @Column(name="nazwisko")
    private String nazwisko;
    @Column(name="employee_condition")
    @Enumerated(EnumType.STRING)
    private EmployeeCondition employeeCondition;
    @Column(name = "rokUrodzenia ")
    private int rokUrodzenia;
    @Column(name = "wynagrodzenie")
    private double wynagrodzenie;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "groupId")
   // @JsonIgnore
    private GroupEmployee group;

    public Employee() {
    }

    public Employee(Long id, String imie, String nazwisko, EmployeeCondition employeeCondition, int rokUrodzenia, double wynagrodzenie, GroupEmployee groupEmployee) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.employeeCondition = employeeCondition;
        this.rokUrodzenia = rokUrodzenia;
        this.wynagrodzenie = wynagrodzenie;
        this.group = groupEmployee;
    }

    public Employee(String imie, String nazwisko, EmployeeCondition employeeCondition, int rokUrodzenia, double wynagrodzenie, GroupEmployee groupEmployee) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.employeeCondition = employeeCondition;
        this.rokUrodzenia = rokUrodzenia;
        this.wynagrodzenie = wynagrodzenie;
        this.group = groupEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public GroupEmployee getGroup() {
        return group;
    }

    public void setGroup(GroupEmployee group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", employeeCondition=" + employeeCondition +
                ", rokUrodzenia=" + rokUrodzenia +
                ", wynagrodzenie=" + wynagrodzenie +
                ", group=" + group +
                '}';
    }
}

