import empdep.service.ConnectorDAO;
import empdep.domain.Department;
import empdep.domain.Employee;
import empdep.service.NewHibernateUtil;

public class ConnectorDAOMain {

    
    public static void main(String[] args) { 
        System.out.println("*****************************Start ConnectorDAOMain");    
        ConnectorDAO con = new ConnectorDAO();        
        System.out.println("Count of departments: " + con.getAllDepartment().size());    
        for (Department d: con.getAllDepartment()) {
            System.out.println(d.getDepartmentId());          
        }               
        
        System.out.println("Count of employees: " + con.getAllEmployee().size());    
        for (Employee e: con.getAllEmployee()) {
            System.out.println(e.getEmployeeId());          
        }                   
        
        NewHibernateUtil.getSessionFactory().getCurrentSession().close();
        NewHibernateUtil.getSessionFactory().close();                
        System.out.println("*****************************End ConnectorDAOMain");
        //cloase all
        System.exit(0);         
    }
    
}