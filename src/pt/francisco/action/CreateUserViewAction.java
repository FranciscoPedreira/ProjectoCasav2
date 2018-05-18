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

public class CreateUserViewAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private Integer userId;
	private String username;
	private String password;
	private String confirmPassword;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String isRegisterUser;
    
    /**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
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
	
    /**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	 * @return the isRegisterUser
	 */
	public String getIsRegisterUser() {
		return isRegisterUser;
	}

	/**
	 * @param isRegisterUser the isRegisteUser to set
	 */
	public void setIsRegisterUser(String isRegisterUser) {
		this.isRegisterUser = isRegisterUser;
	}

	public static final long serialVersionUID = 4L;

    public String execute() {
        
    	//coloquei aqui esta action para poder passar o isRegisterUser utilizando o <s:url> que obriga a ter uma action
    	System.out.println("isRegisterUser = " + request.getAttribute("isRegisterUser"));
		return SUCCESS;
        
    }
	
}
