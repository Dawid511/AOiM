package AOiM_GRABALSKI_DAWID_GR2_Zad2;

import java.lang.Comparable;

public class Employee implements Comparable<Employee> {
    String imie;
    String nazwisko;
    EmployeeCondition employeeCondition;
    int rokUrodzenia;
    double wynagrodzenie;

    Employee(String imie, String nazwisko, EmployeeCondition eC, int rokUrodzenia, double wynagrodzenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.employeeCondition = eC;
        this.rokUrodzenia = rokUrodzenia;
        this.wynagrodzenie = wynagrodzenie;

    }

    @Override
    public int compareTo(Employee pracownik) {
        return this.nazwisko.compareTo(pracownik.nazwisko);
    }

    double getWynagrodzenie(){
        return wynagrodzenie;
    }

    
    void printing() {
        System.out.println("imie: " + imie);
        System.out.println("nazwisko: " + nazwisko);
        System.out.println("employeeCondition: " + employeeCondition);
        System.out.println("rok urodzenia: " + rokUrodzenia);
        System.out.println("wynagrodzenie: " + wynagrodzenie);

    }

}
