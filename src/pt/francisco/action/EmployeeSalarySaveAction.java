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

public class EmployeeSalarySaveAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int employeeSalaryId;
	private int employeeId;
	private int salaryId;
	private String employeeWithoutSalaryGroup;
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
	 * @return the employeeWithoutSalaryGroup
	 */
	public String getEmployeeWithoutSalaryGroup() {
		return employeeWithoutSalaryGroup;
	}

	/**
	 * @param employeeWithoutSalaryGroup the employeeWithoutSalaryGroup to set
	 */
	public void setEmployeeWithoutSalaryGroup(String employeeWithoutSalaryGroup) {
		this.employeeWithoutSalaryGroup = employeeWithoutSalaryGroup;
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

	public static final long serialVersionUID = 5678L;

    public String execute() {
    	
    	System.out.println((String) request.getAttribute("employeeWithoutSalaryGroup"));
    	
    	if(((String) request.getAttribute("employeeWithoutSalaryGroup")).equals("-1")){
    		
    		return "error";
    		
    	} else {
    	
	    	String[] parseEmployee = ((String) request.getAttribute("employeeWithoutSalaryGroup")).split(" -");
	    	int employeeWithoutSalaryId = Integer.parseInt(parseEmployee[0]);
	    	
	    	EmployeeSalary es = new EmployeeSalary();
	    	//we get the id from a hidden field in the form, if the id exists we pass it and hibernate knows it has to update
	    	//otherwise the variable will be received as NULL and therefore hibernate knows it has to create a new record
	    	es.setEmployeeId(employeeWithoutSalaryId);
	    	es.setSalaryId((int) request.getAttribute("salaryId"));
	    	
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//creation and persistence of objects to the database in hibernate
			System.out.println("Creating/Updating EmployeeSalary with Id: " + es.getEmployeeSalaryId());
			//if id = 0 then use save() since saveOrUpdate() is not able to determine if the entity is new or detached when id = 0
			if(es.getEmployeeSalaryId() != 0) {
				session.saveOrUpdate(es);
			} else {
				session.save(es);
			}
	    	
			session.getTransaction().commit();
			session.close();
			
			//repopulate the lists after adding the employee
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session sess = sf.openSession();
	        sess.beginTransaction();
	        
	        Query queryEmployeesWithNoSalaryGroup = sess.createNativeQuery("select * from Employee e " + 
	        		"        where not exists (" + 
	        		"        	select * from EmployeeSalary es WHERE e.employeeId = es.employeeId " + 
	        		"        );");
	        ArrayList<Object[]> auxEmployeesWithoutSalary = (ArrayList<Object[]>) queryEmployeesWithNoSalaryGroup.list();
	        for(Object[] e : auxEmployeesWithoutSalary) {
	        	/*e[0] = e.getEmployeeId(); e[1] = e.getFirstName(); e[2] = e.getLastName()*/
	        	System.out.println("e -> " + " " + e[0]  + " - " + e[1]+ " - " + e[2]);
	        }
	        
	        EmployeesWithoutSalaryList = new ArrayList<Object[]>();
	        for (Object[] e : auxEmployeesWithoutSalary) {
	        	Object[] eName = new Object[] {e[0] + " - " + e[1] + " " + e[2]};
	        	EmployeesWithoutSalaryList.add(eName);
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
	
}
