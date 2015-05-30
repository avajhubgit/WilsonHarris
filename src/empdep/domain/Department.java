package empdep.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Department implements java.io.Serializable {
    @Id
    @Column(name="department_id")
    private Integer departmentId;
    @Column(name="department_id",unique = false, nullable = false, length = 100)
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
       this.departmentName = departmentName;
    }
   
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}


