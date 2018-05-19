package pt.francisco.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.EmployeeSalary;
import pt.francisco.hibernate.model.Salary;
import pt.francisco.util.HibernateUtil;

public class EmployeeSalaryDeleteAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private int employeeSalaryId;
	private int employeeId;
	private int salaryId;
	private String employeeToDelete;
	private List<Object[]> EmployeesWithoutSalaryList;
    private List<Object[]> EmployeesWithSalaryList;
    private HttpServletRequest request;
    private HttpServletResponse response;
	
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
    /**
	 * @return the salaryId
	 */
	public int getSalaryId() {
		return salaryId;
	}

	/**
	 * @param salaryId the salaryId to set
	 */
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	/**
	 * @return the employeeSalaryId
	 */
	public int getEmployeeSalaryId() {
		return employeeSalaryId;
	}

	/**
	 * @param employeeSalaryId the employeeSalaryId to set
	 */
	public void setEmployeeSalaryId(int employeeSalaryId) {
		this.employeeSalaryId = employeeSalaryId;
	}

	/**
	 * @return the employeeToDelete
	 */
	public String getEmployeeToDelete() {
		return employeeToDelete;
	}

	/**
	 * @param employeeToDelete the employeeToDelete to set
	 */
	public void setEmployeeToDelete(String employeeToDelete) {
		this.employeeToDelete = employeeToDelete;
	}

	public void setServletRequest(HttpServletRequest request){
    	this.request = request;
    }

    public HttpServletRequest getServletRequest(){
    	return request;
    }

    public void setServletResponse(HttpServletResponse response){
    	this.response = response;
    }

    public HttpServletResponse getServletResponse(){
    	return response;
    }

	/**
	 * @return the employeesWithoutSalaryList
	 */
	public List<Object[]> getEmployeesWithoutSalaryList() {
		return EmployeesWithoutSalaryList;
	}

	/**
	 * @param employeesWithoutSalaryList the employeesWithoutSalaryList to set
	 */
	public void setEmployeesWithoutSalaryList(List<Object[]> employeesWithoutSalaryList) {
		EmployeesWithoutSalaryList = employeesWithoutSalaryList;
	}

	/**
	 * @return the employeesWithSalaryList
	 */
	public List<Object[]> getEmployeesWithSalaryList() {
		return EmployeesWithSalaryList;
	}

	/**
	 * @param employeesWithSalaryList the employeesWithSalaryList to set
	 */
	public void setEmployeesWithSalaryList(List<Object[]> employeesWithSalaryList) {
		EmployeesWithSalaryList = employeesWithSalaryList;
	}

	public static final long serialVersionUID = 1234L;

    public String execute() {
    	
    	final ArrayList<Salary> currentSalary;
    	ArrayList<EmployeeSalary> listEmployeeSalary;
        
        if(request.getAttribute("employeeToDelete") == null) {
        	return "error";
        }
        
        String[] parseEmployee = ((String) request.getAttribute("employeeToDelete")).split(" -");
    	int employeeId = Integer.parseInt(parseEmployee[0]);
    	
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
		Query queryEmployeeSalary = session.createQuery("from EmployeeSalary where employeeId = :employeeId");
		queryEmployeeSalary.setParameter("employeeId", employeeId);
		listEmployeeSalary = (ArrayList<EmployeeSalary>) queryEmployeeSalary.list();
		System.out.println("EmployeeSalaryId to delete = " + listEmployeeSalary.get(0).getEmployeeSalaryId());
    	
		//deletion of object from the database in hibernate
		//we get the id from a hidden field in the form so hibernate knows which employee to delete
		EmployeeSalary es = session.load(EmployeeSalary.class, listEmployeeSalary.get(0).getEmployeeSalaryId());
		System.out.println("Deleting EmployeeSalary with Id: " + listEmployeeSalary.get(0).getEmployeeSalaryId());
		session.delete(es);
		
		session.getTransaction().commit();
		session.close();
		
		//repopulate the lists after deleting the employee
		/*SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
        Session sess = sessionfactory.openSession();*/
		Session sess = sf.openSession();
		sess.beginTransaction();
        
        Query queryEmployeesWithNoSalaryGroup = sess.createNativeQuery("select * from Employee e " + 
        		"        where not exists (" + 
        		"        	select * from EmployeeSalary es WHERE e.employeeId = es.employeeId " + 
        		"        );");
        ArrayList<Object[]> auxEmployeesWithoutSalary = (ArrayList<Object[]>) queryEmployeesWithNoSalaryGroup.list();
        if(!auxEmployeesWithoutSalary.isEmpty()) {
	        for(Object[] e : auxEmployeesWithoutSalary) {
	        	/*e[0] = e.getEmployeeId(); e[1] = e.getFirstName(); e[2] = e.getLastName()*/
	        	System.out.println("e -> " + " " + e[0]  + " - " + e[1]+ " - " + e[2]);
	        }
        }
        
	    if(!auxEmployeesWithoutSalary.isEmpty()) {
	        EmployeesWithoutSalaryList = new ArrayList<Object[]>();
	        for (Object[] e : auxEmployeesWithoutSalary) {
	        	Object[] eName = new Object[] {e[0] + " - " + e[1] + " " + e[2]};
	        	EmployeesWithoutSalaryList.add(eName);
	        }
	    }
		
		Query queryEmployeesWithSalaryGroup = sess.createNativeQuery("select * from Employee e " + 
        		"        where exists (" + 
        		"        	select * from EmployeeSalary es WHERE e.employeeId = es.employeeId AND salaryId = :salaryId" + 
        		"        );");
		queryEmployeesWithSalaryGroup.setParameter("salaryId", salaryId);
        ArrayList<Object[]> auxEmployeesWithSalary = (ArrayList<Object[]>) queryEmployeesWithSalaryGroup.list();
        for(Object[] e : auxEmployeesWithSalary) {
        	/*e[0] = e.getEmployeeId(); e[1] = e.getFirstName(); e[2] = e.getLastName()*/
        	System.out.println("e -> " + " " + e[0]  + " - " + e[1]+ " - " + e[2]);
        }
  
    	EmployeesWithSalaryList = new ArrayList<Object[]>();
        for (Object[] e : auxEmployeesWithSalary) {
        	Object[] eName = new Object[] {e[0] + " - " + e[1] + " " + e[2]};
        	EmployeesWithSalaryList.add(eName);
        }

        
        sess.getTransaction().commit();
		sess.close();
    	
		return SUCCESS;
		
    }
	
}
