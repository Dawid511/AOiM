package AOiM_GRABALSKI_DAWID_GR2_Zad2;

import java.util.ArrayList;
import java.util.List;

public class KolekcjeOdwzorowania {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Bartek", "Wolski", EmployeeCondition.CHORY, 2000, 1000.11);
        Employee emp2 = new Employee("Jan", "Kowalski", EmployeeCondition.CHORY, 2000, 2000.22);
        Employee emp3 = new Employee("Marek3", "Pawlowksi3", EmployeeCondition.CHORY, 2000, 3000.33);
        Employee emp4 = new Employee("Marek4", "Pawlowksi4", EmployeeCondition.CHORY, 2004, 4000.44);
        Employee emp5 = new Employee("Marek5", "Pawlowksi5", EmployeeCondition.CHORY, 2000, 5000.55);
        Employee emp6 = new Employee("Marek6", "Pawlowksi6", EmployeeCondition.CHORY, 2000, 6000.66);


        ArrayList<Employee> arrl = new ArrayList<>();
        arrl.add(emp1);
        arrl.add(emp2);
        ClassEmployee class1 = new ClassEmployee("class1", arrl, 7);
        class1.addEmployee(emp5);
        class1.addEmployee(emp3);
        class1.addEmployee(emp6);
        class1.addEmployee(emp4);

        System.out.println("Zmiana wynagrodzenia --------------------");
        class1.addSalary(emp3, 4000);
        class1.summary();

        System.out.println("usuniecie pracownika--------------------");
        class1.removeEmployee(emp6);
        class1.summary();

        System.out.println("zmiana kondycji pracownika --------------------");
        class1.changeCondition(emp4, EmployeeCondition.DELEGACJA);
        class1.summary();
        
        System.out.println("szukanie --------------------");
        class1.search("Pawlowksi3");

        System.out.println("szukanie fragment --------------------");
        List<Employee> szukanie_fragmet = new ArrayList<>();
        szukanie_fragmet = class1.searchPartial("Pawl");
        for (Employee employee : szukanie_fragmet) {
            employee.printing();
        }

        System.out.println("zliczanie --------------------");
        System.out.println(class1.countByCondition(EmployeeCondition.CHORY));
        
        System.out.println("Sortowanie po nazwisku --------------------");
        List<Employee> sortowanie_nazwisko = new ArrayList<>();
        sortowanie_nazwisko = class1.sortByName();
        for (Employee employee : sortowanie_nazwisko) {
            System.out.println(employee.nazwisko);
        }

        System.out.println("Sortowanie po wynagrodzeniu --------------------");
        List<Employee> sortowanie_wynagrodzenie = new ArrayList<>();
        sortowanie_wynagrodzenie = class1.sortBySalary();
        for (Employee employee : sortowanie_wynagrodzenie) {
            System.out.println(employee.wynagrodzenie);
        }

        System.out.println("Element max --------------------");
        class1.max().printing();



        System.out.println("ClassContainer --------------------");
        ClassContainer container1 = new ClassContainer();
        container1.addClass("class1", 7);
        container1.addClass("class2", 4);
        container1.addClass("class3", 3);
        container1.addClass("class4", 2);

        
        container1.map.get("class2").addEmployee(emp6);
        List<String> arr2 = new ArrayList<>();
        arr2 = container1.findEmpty();

        for (String string : arr2) {
            System.out.println(string);
        }

        container1.summary();

    }
}
