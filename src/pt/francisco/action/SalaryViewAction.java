package pt.francisco.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
//import org.hibernate.Session;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Salary;
import pt.francisco.hibernate.util.HibernateUtil;

//import pt.francisco.hibernate.model.Salary;
//import pt.francisco.hibernate.util.HibernateUtil;

public class SalaryViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
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
        
    	Salary s = new Salary();
    	Salary.SalaryId sId = new Salary.SalaryId();
    	sId.setFirstName((String) request.getAttribute("firstName"));
    	sId.setLastName((String) request.getAttribute("lastName"));
    	s.setId(sId);
    	s.setStep((String) request.getAttribute("step"));
    	s.setValue((String) request.getAttribute("value"));
    	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//creation and persistence of objects to the database in hibernate
		
		System.out.println("Creating/Updating Salary Register from Employee: " + s.getId().getFirstName()
				+ " - " + s.getId().getLastName() + " - " + s.getStep() + " - " + s.getValue());
		session.saveOrUpdate(s);
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
        
    }
	
}
