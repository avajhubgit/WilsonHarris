package empdep.service;

import org.hibernate.Session;
import empdep.domain.Department;
import empdep.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

//data handling layer
public class ConnectorDAO {
    //collection of departments
    private List<Department> departments = new ArrayList<>();
    //collection of employees
    private List<Employee> employees = new ArrayList<>();
    //get collection of departments
    public List<Department> getAllDepartment() {
        return departments;
    }
    //get collection of employees
    public List<Employee> getAllEmployee() {
        return employees;
    }
    
    //search into list of emploees
    public List<Employee> getFilteredEmployee(String searchString) {
        //search string to upper
        String newSearchString = searchString.toUpperCase();
        
        //temprorary list
        List<Employee> emp_list = new ArrayList<>();
        
        //for each employee from list
        for (Employee e: employees) {
            //check search criteria
            if  (e.getEmployeeFirstName().toUpperCase().contains(newSearchString) || 
                 e.getEmployeeLastName().toUpperCase().contains(newSearchString) ||
                 e.getEmployeeLogin().toUpperCase().contains(newSearchString) ||
                 e.getEmployeePhone().toUpperCase().contains(newSearchString) ||
                 e.getEmployeePosition().toUpperCase().contains(newSearchString)
                 ){
                emp_list.add(e);
            }
        }
        return emp_list;
    }
    
    public void addEmployee(Employee employee) {
        //encrypt employee password
        
        //Hibernate new session
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();         
        //add employee to list
        employees.add(employee);
        //add employee to database
        Transaction tra = null;
        try {
            tra = session.beginTransaction();            
            Query q = session.createQuery("insert into Employee(employee_first_name, employee_last_name, "
                    + "employee_login, employee_password, employee_email,"
                    + "department_id, employee_phone, employee_position) "
                    + "values (':employeeFirstName',"
                    + "':employeeLastName',"
                    + "':employeeLogin',"
                    + "':employeePassword',"
                    + "':employeeEmail',"
                    + "':departmentId',"
                    + "':employeePosition');");                                  
            q.setProperties(employee);
            int result = q.executeUpdate();
            tra.commit();
        }
        catch (HibernateException e)
        {
            System.err.println("Exception occurred: " + e.toString());
            if (tra != null){
                tra.rollback();
            }
        }
    }
        
    public void updateEmployee(Employee employee) {
        //Hibernate new session
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //update employee into database
        Transaction tra = null;
        try {
            tra = session.beginTransaction();
            Query q = session.createQuery("update Employee "
                    + "set employee_first_name=:employeeFirstName,"
                    + "employee_last_name=:employeeLastName,"
                    + "employee_login=:employeeLogin,"
                    + "employee_password=:employeePassword,"
                    + "employee_email=:employeeEmail,"
                    + "department_id=:departmentId,"
                    + "employee_phone=:employeePhone,"
                    + "employee_position=:employeePosition "
                    + "where employee_id=:employeeId;");
            q.setProperties(employee);
            int result = q.executeUpdate();
            tra.commit();
        }
        catch (HibernateException e)
        {
            System.err.println("Exception occurred: " + e.toString());
            if (tra != null){
                tra.rollback();
            }
        }
    }
        
    public void removeEmployee(Employee employee) {
        //Hibernate new session
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //remove employee from list
        employees.remove(employee);
        //remove employee from database
        Transaction tra = null;
        try {
            tra = session.beginTransaction();
            Query q = session.createQuery("delete from Employee "
                    + "where employee_id=:employeeId;");
            q.setProperties(employee);
            int result = q.executeUpdate();
            tra.commit();
        } 
        catch (HibernateException e)
        {
            System.err.println("Exception occurred: " + e.toString());
            if (tra != null){
                tra.rollback();
            }
        }
    }
    
    //read departments into list
    private void ReadDepartment(){
        //Hibernate new session
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tra = null;
        try {
            tra = session.beginTransaction();
            Query q = session.createQuery("from Department order by department_id");
            departments.addAll(q.list());
            tra.commit();
        }
        catch (HibernateException e)
        {
            System.err.println("Exception occurred: " + e.toString());
            if (tra != null){
                tra.rollback();
            }
        }
    }
    
    //read employees into list
    private void ReadEmployee(){
        //Hibernate new session
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tra = null;
        try {
            tra = session.beginTransaction();
            Query q = session.createQuery("from Employee order by employee_id");
            employees.addAll(q.list());
            tra.commit();
        }
        catch (HibernateException e)
        {
            System.err.println("Exception occurred: " + e.toString());
            if (tra != null){
                tra.rollback();
            }
        }
    }
    
    public ConnectorDAO() {
        //read employees into list
        ReadEmployee();
        //read departments into list
        ReadDepartment();
    }
    
    //check user login
    public boolean isAuthorizedUser(String login, String password){
        for (Employee e: employees) {
            //check every employee
            if (e.getEmployeeLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}