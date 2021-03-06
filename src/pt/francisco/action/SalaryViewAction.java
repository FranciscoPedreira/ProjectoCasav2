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
import pt.francisco.util.HibernateUtil;

//import pt.francisco.hibernate.model.Salary;
//import pt.francisco.hibernate.util.HibernateUtil;

public class SalaryViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private int salaryId;
	private String salaryGroup;
	private String value;
    private HttpServletRequest request;
    private HttpServletResponse response;

	/**
	 * @return the salaryId
	 */
	public int getSalaryId() {
		return salaryId;
	}

	/**
	 * @return the salaryGroup
	 */
	public String getSalaryGroup() {
		return salaryGroup;
	}

	/**
	 * @param salaryId the salaryId to set
	 */
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	/**
	 * @param salaryGroup the salaryGroup to set
	 */
	public void setSalaryGroup(String salaryGroup) {
		this.salaryGroup = salaryGroup;
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
    	//still necessary to fetch the id from the request in case the salary is not in the DB we can choose between save() or saveOrUpdate()
    	if(((int) request.getAttribute("salaryId")) == 0) {
    		s.setSalaryId(0);
    	} else {
    		s.setSalaryId((int) request.getAttribute("salaryId"));
    	}
    	s.setSalaryGroup((String) request.getAttribute("salaryGroup"));
    	s.setValue((String) request.getAttribute("value"));
    	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//creation and persistence of objects to the database in hibernate
        
        System.out.println("Creating/Updating Salary with id: " + s.getSalaryId());
        
    	//if id = 0 then use save() since saveOrUpdate() is not able to determine if the entity is new or detached when id = 0
		if((int) s.getSalaryId() != 0) {
			session.saveOrUpdate(s);
		} else {
			session.save(s);
		}
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
        
    }
	
}
