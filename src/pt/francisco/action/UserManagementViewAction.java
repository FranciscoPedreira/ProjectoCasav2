package pt.francisco.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
//import org.hibernate.Session;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Salary;
import pt.francisco.hibernate.model.User;
import pt.francisco.util.HibernateUtil;

//import pt.francisco.hibernate.model.Salary;
//import pt.francisco.hibernate.util.HibernateUtil;

public class UserManagementViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private String username;
	private String password;
    private HttpServletRequest request;
    private HttpServletResponse response;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
        
    	User u = new User();
    	u.setUsername((String) request.getAttribute("username"));
    	u.setPassword((String) request.getAttribute("password"));
    	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//call function to hash password introduced by the user
		
		
		//creation and persistence of objects to the database in hibernate
		System.out.println("Creating/Updating User: " + u.getUsername() + " - " + u.getPassword());
		session.saveOrUpdate(u);
		
		session.getTransaction().commit();
		session.close();
    	
		return SUCCESS;
        
    }
	
}
