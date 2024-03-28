package com.example.restapi.group;

import com.example.restapi.emp.Employee;
import com.example.restapi.rate.Rating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class GroupEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nazwa", unique = true)
    private String name;
    @Column(name = "maxNumberOfEmployees")
    private int maxNumberOfEmployees;

    @Transient
    private double fill;

    // Gettery, Settery i inne metody

    public double getFill() {
        return fill;
    }

    public void setFill(double fill) {
        this.fill = fill;
    }

    //@JsonManagedReference
    //@OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonIgnore
    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Employee> ListOfEmployees;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Rating> oceny;



    public GroupEmployee() {
    }

    public GroupEmployee(String name, int maxNumberOfEmployees) {
        this.name = name;
        maxNumberOfEmployees = maxNumberOfEmployees;
    }

    public GroupEmployee(Long id, String name, int maxNumberOfEmployees) {
        this.id = id;
        this.name = name;
        maxNumberOfEmployees = maxNumberOfEmployees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getListOfEmployees() {
        return ListOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        ListOfEmployees = listOfEmployees;
    }

    public int getMaxNumberOfEmployees() {
        return maxNumberOfEmployees;
    }

    public void setMaxNumberOfEmployees(int maxNumberOfEmployees) {
        maxNumberOfEmployees = maxNumberOfEmployees;
    }


    public List<Rating> getOceny() {
        return oceny;
    }

    public void setOceny(List<Rating> oceny) {
        this.oceny = oceny;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ListOfEmployees=" + ListOfEmployees +
                ", MaxNumberOfEmployees=" + maxNumberOfEmployees +
                '}';
    }
}
