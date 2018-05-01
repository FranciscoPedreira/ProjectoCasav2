package pt.francisco.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.util.HibernateUtil;

public class EmployeeViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String country;
	private String role;
    private HttpServletRequest request;
    private HttpServletResponse response;
	
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
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
        
    	Employee e = new Employee();
    	//we get the id from a hidden field in the form, if the id exists we pass it and hibernate knows it has to update
    	//otherwise the variable will be received as NULL and therefore hibernate knows it has to create a new record
    	e.setEmployeeId((int) request.getAttribute("employeeId"));
    	e.setFirstName((String) request.getAttribute("firstName"));
    	e.setLastName((String) request.getAttribute("lastName"));
    	e.setAddress((String) request.getAttribute("address"));
    	e.setCountry((String) request.getAttribute("country"));
    	e.setRole((String) request.getAttribute("role"));
    	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//creation and persistence of objects to the database in hibernate
		System.out.println("Creating/Updating Employee with Id: " + e.getEmployeeId() + " - " + e.getFirstName());
		//if id = 0 then use save() since saveOrUpdate() is not able to determine if the entity is new or detached when id = 0
		if(e.getEmployeeId() != 0) {
			session.saveOrUpdate(e);
		} else {
			session.save(e);
		}
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
        
    }
	
}
