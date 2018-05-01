package pt.francisco.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
//import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.Salary;
import pt.francisco.hibernate.util.HibernateUtil;

//import pt.francisco.hibernate.model.Salary;
//import pt.francisco.hibernate.util.HibernateUtil;

public class SalaryViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String step;
	private String value;
    private HttpServletRequest request;
    private HttpServletResponse response;
	private ArrayList<Employee> listEmployee;
    
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
        
    	Salary s = new Salary(); 
    	//still necessary to fetch the id from the request in case the salary is not in the DB we can choose between save() or saveOrUpdate()
    	s.setEmployeeId((int) request.getAttribute("employeeId"));
    	s.setFirstName((String) request.getAttribute("firstName"));
    	s.setLastName((String) request.getAttribute("lastName"));
    	s.setStep((String) request.getAttribute("step"));
    	s.setValue((String) request.getAttribute("value"));
    	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//creation and persistence of objects to the database in hibernate
		
		System.out.println("Creating/Updating Salary Register from Employee: " + s.getEmployeeId() + " - " + s.getFirstName()
				+ " - " + s.getLastName() + " - " + s.getStep() + " - " + s.getValue());
		//Query to get Id from Employee using firstname and lastname
		
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Query queryEmployee = sess.createQuery("from Employee where firstname = :firstname and lastname = :lastname");
		queryEmployee.setParameter("firstname", firstName);
		queryEmployee.setParameter("lastname", lastName);
        listEmployee = (ArrayList<Employee>) queryEmployee.list();
        
        //if the employee exists in the DB, fetch it's id
        for(Employee e : listEmployee) {
        	
        	System.out.println(e.getEmployeeId());
        	
        	//set the id of the employee to follow the foreign key rule
        	s.setEmployeeId((int) e.getEmployeeId());
        	
        }
        
    	//if id = 0 then use save() since saveOrUpdate() is not able to determine if the entity is new or detached when id = 0
		if((int) s.getEmployeeId() != 0) {
			session.saveOrUpdate(s);
		} else {
			session.save(s);
		}
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
        
    }
	
}
