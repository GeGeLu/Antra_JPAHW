package entity;

import javax.persistence.*;

@Entity
//@NamedQuery(name = "Employee.byDepartment", query = "SELECT e FROM Employee e.depart")
public class Employee {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "department_id")
    private Integer departmentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (departmentId != null ? !departmentId.equals(employee.departmentId) : employee.departmentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        return result;
    }


//    @ManyToOne
//    private Department manyToOne;
//
//    public Department getManyToOne() {
//        return manyToOne;
//    }
//
//    public void setManyToOne(Department manyToOne) {
//        this.manyToOne = manyToOne;
//    }
}
