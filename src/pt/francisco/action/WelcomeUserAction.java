package pt.francisco.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.Salary;
import pt.francisco.hibernate.model.User;
import pt.francisco.hibernate.util.HibernateUtil;

public class WelcomeUserAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	public static final long serialVersionUID = 1L;

    private String userName;
    private String message;
    private String passWord;
    private ArrayList<User> listUser;
    private ArrayList<Employee> listEmployee;
    private ArrayList<Salary> listSalary;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public String execute() {
            
    	message = "Welcome " + userName;
            
		System.out.println(userName + " - " + passWord);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
 
        /*fetching objects from the database in hibernate*/

        Query queryUser = sess.createQuery("from User where username = :username");
        queryUser.setParameter("username", userName);
        listUser = (ArrayList<User>) queryUser.list();
        for(User u : listUser) {
        	System.out.println(u.getUsername() + " - " + u.getPassword());
        }
        
     	System.out.println("########## EMPLOYEES ##########");
        
   	    Query queryEmployee = sess.createQuery("from Employee");
        listEmployee = (ArrayList<Employee>) queryEmployee.list();
        for(Employee e : listEmployee) {
        	System.out.println(e.getId().getFirstName() + " - " + e.getId().getLastName() + " - "
        	+ e.getCountry() + " - " + e.getAddress() + " - " + e.getRole());
        }
        
        //set the listEmployee variable in the session so it can be acessed in the EmployeeView
        HttpSession session = request.getSession();
        session.setAttribute("listEmployee", listEmployee);
        
        System.out.println("########## SALARY ##########");
        
   	    Query querySalary = sess.createQuery("from Salary");
        listSalary = (ArrayList<Salary>) querySalary.list();
        for(Salary s : listSalary) {
        	System.out.println(s.getId().getFirstName() + " - " + s.getId().getLastName() + " - "
        	+ s.getStep() + " - " + s.getValue());
        }
        
        //set the listSalary variable in the session so it can be acessed in the SalaryView
        session = request.getSession();
        session.setAttribute("listSalary", listSalary);
        
        
        System.out.println("End of welcome user action");
        
        return SUCCESS;
        
    }

    public void setUserName(String userName) {
    	this.userName = userName;
    }

    public void setPassWord(String passWord) {
    	this.passWord = passWord;
    }
    
    public void setMessage(String message) {
    	this.message = message;
    }
    
    public void setListUser(ArrayList<User> listUser) {
    	this.listUser = listUser;
    }
    
    public void setListEmployee(ArrayList<Employee> listEmployee) {
    	this.listEmployee = listEmployee;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassWord() {
        return passWord;
	}

    public String getMessage() {
    	return message;
    }
    
    public ArrayList<User> getListUser() {
    	return listUser;
    }
    
    public ArrayList<Employee> getListEmployee() {
    	return listEmployee;
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
    
}
