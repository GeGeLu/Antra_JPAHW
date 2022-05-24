import javax.persistence.*;

import entity.Department;
import entity.EmpDep;
import entity.Employee;

public class myJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //insertToEmployee(entityManager);
        //updateEmployee(entityManager);
        //getEmployeeById(entityManager);
        //getEmployeeByDepartmentId(entityManager);
        addToJunctionTable1(entityManager);
        //addToJunctionTable2(entityManager);
        //addToJunctionTable3(entityManager);

    }

    private static void insertToEmployee(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee e1 = new Employee();
        e1.setEid(10);
        e1.setName("Mark");

        em.persist(e1);
        transaction.commit();

    }

    private static void updateEmployee(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee e1 = new Employee();
        e1.setEid(4);
        e1.setName("Ellen");

        em.merge(e1);
        transaction.commit();

    }

    private static void getEmployeeById(EntityManager em) {
        Query query = em.createNativeQuery("select e.name from Employee e where e.eid = ?");
        query.setParameter(1,1);
        Object e = query.getSingleResult();
        System.out.println(e);
    }

   private static void addToJunctionTable1(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee e = new Employee();

        e.setName("Penny");


        Department d = new Department();
        d.setName("Finance");
        em.merge(d);

        EmpDep ed = new EmpDep();
        ed.setEmployee(e);
        ed.setDepartment(d);
        d.addEmpDep(ed);

        em.merge(e);
        transaction.commit();
   }

//   private static void addToJunctionTable2(EntityManager em) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        Query query = em.createNativeQuery("INSERT INTO EMPDEP (E_ID, D_ID) VALUES(?1,?1)");
//        query.setParameter(1,1);
//        query.executeUpdate();
//        transaction.commit();
//   }
//
//   private static void addToJunctionTable3(EntityManager em) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        Employee e = em.find(Employee.class,1);
//        Department d = em.find(Department.class,2);
//        EmpDep ed = new EmpDep();
//        ed.setEmployee(e);
//        ed.setDepartment(d);
//        em.merge(ed);
//        transaction.commit();
//   }


}
