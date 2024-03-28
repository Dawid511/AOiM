package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
public class EmployeeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String NazwaGrupyPracowniczej;

    @OneToMany(mappedBy = "employeeGroup")
    List<Employee> listEmployee;
    int maxLiczbaPracownikow;

    public EmployeeGroup(String NazwaGrupyPracowniczej, int maxNoOfEmployees) {
        this.NazwaGrupyPracowniczej = NazwaGrupyPracowniczej;
        this.maxLiczbaPracownikow = maxNoOfEmployees;
    }

    public EmployeeGroup() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> listEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
    public List<Employee> getListOfEmployees() {
        return listEmployee;
    }

    public int getMaxNoOfEmployees() {
        return maxLiczbaPracownikow;
    }

    public void setMaxNoOfEmployees(int maxNoOfEmployees) {
        this.maxLiczbaPracownikow = maxNoOfEmployees;
    }


    void addSalary(Employee employee, double wyna) {
        if (listEmployee.contains(employee)) {
            employee.salary = wyna;
        }
    }

    

    void changeCondition(Employee emp, EmployeeCondition empCon){
        for (Employee employee : listEmployee) {
            if(employee.equals(emp)){
                employee.empCond = empCon;
            }
        }
    }

    void search(String nazwisko){
        for (Employee employee : listEmployee) {
            if(employee.surname.compareTo(nazwisko) == 1){
                employee.printing();
            }
        }
    }

    public List<Employee> searchPartial(String fragmentNazwiska){
        List<Employee> arrl = new ArrayList<>();

        for( Employee employee : listEmployee) {
            if(employee.surname.contains(fragmentNazwiska)) {
                arrl.add(employee);
            }
        }
        return arrl;
    }

    int countByCondition(EmployeeCondition empCon) {
        int count = 0;

        for(Employee employee : listEmployee) {
            if(employee.empCond.equals(empCon)){
                count++;
            }
        }

        return count;
    }

    void summary() {
        System.out.println("NazwaGrupyPracowniczej: " + NazwaGrupyPracowniczej);
        System.out.println("maxLiczbaPracownikow: " + maxLiczbaPracownikow);
        System.out.println("czlonkowie:");
        for (Employee employee : listEmployee) {
            employee.printing();
            System.out.println();
        }

    }
    List<Employee> sortByName() {
        Collections.sort(listEmployee);
        return listEmployee;
    }

    List<Employee> sortBySalary() {
        listEmployee.sort((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()));
        return listEmployee;
    }

    Employee max() {
        return Collections.max(listEmployee);
    }


}
