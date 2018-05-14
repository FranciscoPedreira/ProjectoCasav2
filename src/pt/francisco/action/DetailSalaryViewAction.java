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

public class DetailSalaryViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int salaryId;
	private String salaryGroup;
	private String value;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ArrayList<Employee> EmployeesWithoutSalaryList;
	
	/**
	 * @return the salaryId
	 */
	public int getSalaryId() {
		return salaryId;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param salaryId the salaryId to set
	 */
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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

	/**
	 * @return the employeesWithoutSalaryList
	 */
	public ArrayList<Employee> getEmployeesWithoutSalaryList() {
		return EmployeesWithoutSalaryList;
	}

	/**
	 * @param employeesWithoutSalaryList the employeesWithoutSalaryList to set
	 */
	public void setEmployeesWithoutSalaryList(ArrayList<Employee> employeesWithoutSalaryList) {
		EmployeesWithoutSalaryList = employeesWithoutSalaryList;
	}

	public static final long serialVersionUID = 4L;

    public String execute() {
        
    	final ArrayList<Salary> currentSalary;
    	
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        
        Integer employeeId = (Integer) request.getAttribute("employeeId");
        
        //get employee details
    	Query querySalary = sess.createQuery("from Salary where salaryId = :salaryId");
    	querySalary.setParameter("salaryId", salaryId);
    	currentSalary = (ArrayList<Salary>) querySalary.list();
        for(Salary s : currentSalary) {
        	System.out.println(s.getSalaryId() + " - " + s.getSalaryGroup() + " - " + s.getValue());
        }
        
        Query queryEmployeesWithNoSalaryGroup = sess.createNativeQuery("select e.employeeId from Employee e " + 
        		"        where not exists (" + 
        		"        	select es.employeeId from EmployeeSalary es WHERE e.employeeId = es.employeeId " + 
        		"        );");
        EmployeesWithoutSalaryList = (ArrayList<Employee>) queryEmployeesWithNoSalaryGroup.list();
        /*for(Employee e : EmployeesWithoutSalaryList) {
        	System.out.println(e.getEmployeeId() + " - " + e.getFirstName()+ " - " + e.getLastName());
        }*/
        
        //set variables to be used in the view
        request.setAttribute("salaryId", currentSalary.get(0).getSalaryId());
        request.setAttribute("salaryGroup", currentSalary.get(0).getSalaryGroup());
        request.setAttribute("value", currentSalary.get(0).getValue());
        request.setAttribute("employeesWithNoSalary", EmployeesWithoutSalaryList);
		
        return SUCCESS;
        
    }
	
}
