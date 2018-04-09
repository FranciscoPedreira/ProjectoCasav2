package pt.francisco.action;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.User;
import pt.francisco.hibernate.util.HibernateUtil;

public class WelcomeUserAction extends ActionSupport{
	
	public static final long serialVersionUID = 1L;

    private String userName;
    private String message;
    private String passWord;
    
    public String execute() {
            
    	message = "Welcome " + userName;
            
		System.out.println(userName + " - " + passWord);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
 
        /*fetching objects from the database in hibernate*/

        Query queryUser = sess.createQuery("from User where username = :username");
        queryUser.setParameter("username", userName);
        ArrayList<User> listUser = (ArrayList<User>) queryUser.list();
        for(User u : listUser) {
        	System.out.println(u.getUsername() + " - " + u.getPassword());
        }
        
     	System.out.println("########## EMPLOYEES ##########");
        
   	    Query queryEmployee = sess.createQuery("from Employee");
        ArrayList<Employee> listEmployee = (ArrayList<Employee>) queryEmployee.list();
        for(Employee e : listEmployee) {
        	System.out.println(e.getId().getFirstName() + " - " + e.getId().getLastName() + " - "
        	+ e.getCountry() + " - " + e.getAddress() + " - " + e.getRole());
        }
            
        System.out.println("End of welcome user action");
        
        return SUCCESS;
        
    }

    public void setUserName(String userName) {
    	this.userName = userName;
    }

    public void setPassword(String passWord) {
    	this.passWord = passWord;
    }
    
    public void setMessage(String message) {
    	this.message = message;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return passWord;
	}

    public String getMessage() {
    	return message;
    }
    
}
