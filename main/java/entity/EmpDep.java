package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EmpDep {

    public EmpDep (Employee employee, Department department){
        this.employee = employee;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "E_ID")
    private Integer eId;
    @Basic
    @Column(name = "D_ID")
    private Integer dId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "d_id")
    private Department department;

    public EmpDep() {

    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpDep empDep = (EmpDep) o;

        if (eId != null ? !eId.equals(empDep.eId) : empDep.eId != null) return false;
        if (dId != null ? !dId.equals(empDep.dId) : empDep.dId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId != null ? eId.hashCode() : 0;
        result = 31 * result + (dId != null ? dId.hashCode() : 0);
        return result;
    }
}
