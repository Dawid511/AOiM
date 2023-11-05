package AOiM_GRABALSKI_DAWID_GR2_Zad2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassEmployee {
    String NazwaGrupyPracowniczej;
    int maxLiczbaPracownikow;
    List<Employee> listEmployee = new ArrayList<>();
    /// Employee[] listEmployee = new Employee[maxLiczbaPracownikow];
    int aktualnaLiczbaPracownikow;

    void addEmployee(Employee employee) {
        if (aktualnaLiczbaPracownikow < maxLiczbaPracownikow) {
            int temp = aktualnaLiczbaPracownikow;
            boolean czy = true;
            while (temp > 0) {
                temp--;
                if (employee.compareTo(listEmployee.get(temp)) == 1) {
                    czy = false;
                    System.out
                            .println("Uzytkownik o zadanym imieniu i nazwisku juz istnieje w tej grupie pracowniczej");
                    // throw new IllegalArgumentException("Uzytkownik o zadanym imieniu i nazwisku
                    // juz istnieje w tej grupie pracowniczej");
                }
                temp--;
            }
            if (czy) {
                listEmployee.add(employee);
                aktualnaLiczbaPracownikow++;
            }
        } else {
            System.out.println("W Grupie nie ma juz miejsca");
            // throw new IllegalArgumentException("W Grupie nie ma juz miejsca");
        }
    }

    ClassEmployee(String NazwaGrupyPracowniczej, List<Employee> le, int maxLiczbaPracownikow) {
        this.NazwaGrupyPracowniczej = NazwaGrupyPracowniczej;
        this.maxLiczbaPracownikow = maxLiczbaPracownikow;
        for (int i = 0; i < le.size(); i++) {
            if (aktualnaLiczbaPracownikow < maxLiczbaPracownikow) {
                int temp = aktualnaLiczbaPracownikow;
                boolean czy = true;
                Employee pom = le.get(i);
                // System.out.println("listEmployee.size:" + listEmployee.size());
                // System.out.println("temp:" + temp);
                while (temp > 0) {
                    temp--;
                    if (pom.compareTo(listEmployee.get(temp)) == 1) {
                        czy = false;
                        System.out.println(
                                "Uzytkownik o zadanym imieniu i nazwisku juz istnieje w tej grupie pracowniczej");
                        // throw new IllegalArgumentException("Uzytkownik o zadanym imieniu i nazwisku
                        // juz istnieje w tej grupie pracowniczej");
                    }
                    temp--;
                }
                if (czy) {
                    listEmployee.add(le.get(i));
                    aktualnaLiczbaPracownikow++;
                }
            } else {
                System.out.println("W grupie nie ma juz miejsca");
            }

        }
    }

    ClassEmployee(String name, int count) {
        this.NazwaGrupyPracowniczej = name;
        this.maxLiczbaPracownikow = count;
    }

    void addSalary(Employee employee, double wyna) {
        if (listEmployee.contains(employee)) {
        employee.wynagrodzenie = wyna;
    }
    }

    void removeEmployee(Employee employee) {
        listEmployee.remove(employee);
    }

    void changeCondition(Employee emp, EmployeeCondition empCon){
         for (Employee employee : listEmployee) {
            if(employee.equals(emp)){
                employee.employeeCondition = empCon;
            }
        }
    }

    void search(String nazwisko){
        for (Employee employee : listEmployee) {
            if(employee.nazwisko.compareTo(nazwisko) == 1){
                employee.printing();
            }
        }
    }

    public List<Employee> searchPartial(String fragmentNazwiska){
        List<Employee> arrl = new ArrayList<>();

        for( Employee employee : listEmployee) {
            if(employee.nazwisko.contains(fragmentNazwiska)) {
                arrl.add(employee);
            }
        }
        return arrl;
    }

    int countByCondition(EmployeeCondition empCon) {
        int count = 0;

        for(Employee employee : listEmployee) {
            if(employee.employeeCondition.equals(empCon)){
                count++;
            }
        }

        return count;
    }

    void summary() {
        System.out.println("NazwaGrupyPracowniczej: " + NazwaGrupyPracowniczej);
        System.out.println("maxLiczbaPracownikow: " + maxLiczbaPracownikow);
        System.out.println("liczba aktualnych pracownikow: " + aktualnaLiczbaPracownikow);
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
        listEmployee.sort((emp1, emp2) -> Double.compare(emp2.getWynagrodzenie(), emp1.getWynagrodzenie()));  
        return listEmployee;  
    }

    Employee max() {
        return Collections.max(listEmployee);
    }

}
