package AOiM_GRABALSKI_DAWID_GR2_Zad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClassContainer {
    Map<String, ClassEmployee> map;

    ClassContainer(){
        map = new HashMap<String ,ClassEmployee>();
    }
   

    void addClass(String name, int count){
        ClassEmployee classEmployee = new ClassEmployee(name, count);
        map.put(name, classEmployee);
    }

    void removeClass(String name){
        map.remove(name);
    }

    List<String> findEmpty() {
        List<String> temp = new ArrayList<>();
    
        for (Map.Entry<String, ClassEmployee> entry : map.entrySet()) {
            if (entry.getValue().listEmployee.isEmpty()) {
                temp.add(entry.getKey());
            }
        }
        return temp;
    }

    void summary(){
        for (Map.Entry<String, ClassEmployee> entry : map.entrySet()) {
            System.out.println("Nazwa grupy: " + entry.getValue().NazwaGrupyPracowniczej);
            double a = entry.getValue().aktualnaLiczbaPracownikow;
            double b = entry.getValue().maxLiczbaPracownikow;
            double temp =a/b * 100;
            System.out.println("procent zapelnienia: " + temp + " %");
        }
        
    }

}
