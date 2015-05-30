package empdep.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Employee implements java.io.Serializable {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;
    @Column(name="employee_first_name",unique = false, nullable = false, length = 100)
    private String employeeFirstName;
    @Column(name="employee_last_name",unique = false, nullable = false, length = 100)
    private String employeeLastName;
    @Column(name="employee_login",unique = false, nullable = false, length = 100)
    private String employeeLogin;
    @Column(name="employee_password",unique = false, nullable = false, length = 100)
    private String employeePassword;
    @Column(name="employee_email",unique = false, nullable = false, length = 100)
    private String employeeEmail;
    @Column(name="department_id",unique = false, nullable = false)
    private int departmentId;
    @Column(name="employee_phone",unique = false, nullable = true, length = 100)
    private String employeePhone;
    @Column(name="employee_position",unique = false, nullable = true, length = 100)
    private String employeePosition;

    public Employee() {
    }
	
    public Employee(String employeeFirstName, String employeeLastName, String employeeLogin, String employeePassword, String employeeEmail, int departmentId) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeLogin = employeeLogin;
        this.employeePassword = employeePassword;
        this.employeeEmail = employeeEmail;
        this.departmentId = departmentId;
    }
    public Employee(String employeeFirstName, String employeeLastName, String employeeLogin, String employeePassword, String employeeEmail, int departmentId, String employeePhone, String employeePosition) {
       this.employeeFirstName = employeeFirstName;
       this.employeeLastName = employeeLastName;
       this.employeeLogin = employeeLogin;
       this.employeePassword = employeePassword;
       this.employeeEmail = employeeEmail;
       this.departmentId = departmentId;
       this.employeePhone = employeePhone;
       this.employeePosition = employeePosition;
    }
   
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }
    
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }
    public String getEmployeeLastName() {
        return this.employeeLastName;
    }
    
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    public String getEmployeeLogin() {
        return this.employeeLogin;
    }
    
    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }
    public String getEmployeePassword() {
        return this.employeePassword;
    }
    
    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    public String getEmployeeEmail() {
        return this.employeeEmail;
    }
    
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public int getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getEmployeePhone() {
        return this.employeePhone;
    }
    
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
    public String getEmployeePosition() {
        return this.employeePosition;
    }
    
    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }
}


