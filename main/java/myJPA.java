import javax.persistence.*;

import entity.Employee;

public class myJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //insertToEmployee(entityManager);
        getEmployeeByDepartmentId(entityManager);


    }

    private static void insertToEmployee(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee e1 = new Employee();
        e1.setId(10);
        e1.setName("Mark");
        e1.setDepartmentId(2);
        em.persist(e1);
        transaction.commit();

    }

    private static void getEmployeeByDepartmentId(EntityManager em) {
        Query query = em.createQuery("select e from Employee e where e.departmentId = ?1");
        query.setParameter(1,1);
        Employee e = (Employee) query.getSingleResult();
        System.out.println(e);
    }
}
