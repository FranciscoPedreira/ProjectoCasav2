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
import pt.francisco.hibernate.model.Salary;
import pt.francisco.util.HibernateUtil;

public class EmployeeSalaryDeleteAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int employeeSalaryId;
	private int employeeId;
	private int salaryId;
	private String employeeWithoutSalaryGroup;
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

	

	public static final long serialVersionUID = 4L;

    public String execute() {
    	
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        String[] parseEmployee = ((String) request.getAttribute("employeeIdToDelete")).split(" -");
    	int employeeId = Integer.parseInt(parseEmployee[0]);
    	
		//deletion of object from the database in hibernate
		//we get the id from a hidden field in the form so hibernate knows which employee to delete
		EmployeeSalary es = session.load(EmployeeSalary.class, employeeId);
		System.out.println("Deleting EmployeeSalary with Id: " + employeeId);
		session.delete(es);
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
		
    }
	
}
