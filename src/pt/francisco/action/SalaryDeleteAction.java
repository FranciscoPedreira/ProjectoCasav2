package pt.francisco.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.Salary;
import pt.francisco.util.HibernateUtil;

public class SalaryDeleteAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String step;
	private String value;
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
	 * @return the step
	 */
	public String getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		this.step = step;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
    	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//deletion of object from the database in hibernate
		//we get the id from a hidden field in the form so hibernate knows which employee to delete
		Salary s = session.load(Salary.class, (int) request.getAttribute("employeeId"));
		System.out.println("Deleting Salary Registry of Employee with Id: "+ (int) request.getAttribute("employeeId") + " -  " + (String) request.getAttribute("firstName") + " - " + (String) request.getAttribute("lastName"));
		session.delete(s);
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
        
    }
	
}
