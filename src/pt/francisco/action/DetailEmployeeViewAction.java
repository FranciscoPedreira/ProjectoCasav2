package pt.francisco.action;

import java.util.ArrayList;
import java.util.Enumeration;

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
import pt.francisco.util.HibernateUtil;

public class DetailEmployeeViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String salaryGroup;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the salaryGroup
	 */
	public String getSalaryGroup() {
		return salaryGroup;
	}

	/**
	 * @param salaryGroup the salaryGroup to set
	 */
	public void setSalaryGroup(String salaryGroup) {
		this.salaryGroup = salaryGroup;
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

	public static final long serialVersionUID = 4L;

    public String execute() {
        
    	final ArrayList<Employee> currentEmployee;
    	final ArrayList<String> currentEmployeeSalary;
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        
        Integer employeeId = (Integer) request.getAttribute("employeeId");
        
        //get employee details
    	Query queryEmployee = sess.createQuery("from Employee where employeeId = :employeeId");
    	queryEmployee.setParameter("employeeId", employeeId);
        currentEmployee = (ArrayList<Employee>) queryEmployee.list();
        for(Employee e : currentEmployee) {
        	System.out.println(e.getEmployeeId() + " - " + e.getFirstName() + " - " + e.getLastName() + " - "
        	+ e.getCountry() + " - " + e.getAddress() + " - " + e.getDepartment());
        }
        
        //get employee's salary group
        Query querySalary = sess.createNativeQuery("select s.salaryGroup from Salary s inner join EmployeeSalary es on s.salaryId = es.salaryId"
        		+ " where es.employeeId = :employeeId");
        querySalary.setParameter("employeeId", employeeId);
        currentEmployeeSalary = (ArrayList<String>) querySalary.list();
        for(String salGroup : currentEmployeeSalary) {
        	System.out.println(salGroup);
        	salaryGroup = salGroup;
        }
        
        
        //set variables to be used in the view
        request.setAttribute("firstName", currentEmployee.get(0).getFirstName());
        request.setAttribute("lastName", currentEmployee.get(0).getLastName());
        request.setAttribute("department", currentEmployee.get(0).getDepartment());
        request.setAttribute("salaryGroup", salaryGroup);
		
        return SUCCESS;
        
    }
	
}
