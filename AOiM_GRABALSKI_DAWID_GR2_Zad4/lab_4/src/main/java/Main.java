import org.example.Employee;
import org.example.EmployeeCondition;
import org.example.EmployeeGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.hibernate.jpa.HibernatePersistenceProvider;
import persistence.CustomPersistenceUnitInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true"); // shows queries that happen
        //never use in real-world application
        props.put("hibernate.hbm2ddl.auto", "create"); // create, none, update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            EmployeeGroup grp1 = new EmployeeGroup("grp1", 6);
            EmployeeGroup grp2 = new EmployeeGroup("grp2", 5);


            Employee emp1 = new Employee("Bartek", "Wolski", EmployeeCondition.CHORY, 2000, 1000.11);
            Employee emp2 = new Employee("Jan", "Kowalski", EmployeeCondition.CHORY, 2000, 2000.22);
            Employee emp3 = new Employee("Marek3", "Pawlowksi3", EmployeeCondition.CHORY, 2000, 3000.33);
            Employee emp4 = new Employee("Marek4", "Pawlowksi4", EmployeeCondition.CHORY, 2004, 4000.44);
            Employee emp5 = new Employee("Marek5", "Pawlowksi5", EmployeeCondition.CHORY, 2000, 5000.55);
            Employee emp6 = new Employee("Marek6", "Pawlowksi6", EmployeeCondition.CHORY, 2000, 6000.66);


            emp1.setEmployeeGroup(grp1);
            emp2.setEmployeeGroup(grp1);
            emp3.setEmployeeGroup(grp1);
            emp4.setEmployeeGroup(grp2);
            emp5.setEmployeeGroup(grp2);
            emp6.setEmployeeGroup(grp2);


            grp1.setListEmployee(List.of(emp1, emp2, emp3));
            grp2.setListEmployee(List.of(emp4, emp5, emp6));

            em.persist(emp1);
            em.persist(emp2);
            em.persist(emp3);
            em.persist(emp4);
            em.persist(emp5);
            em.persist(emp6);


            em.persist(grp1);
            em.persist(grp2);


            //Queries
            List<?> employees = em.createQuery("SELECT name from Employee employee").getResultList();
            for(Object i : employees) {
                System.out.println(i);
            }
            em.getTransaction().commit();

        }

    }
}