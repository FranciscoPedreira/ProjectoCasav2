package pt.francisco.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    private ArrayList<User> listUsers;
    private ArrayList<User> currentLoggedOnUser;
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
        
        /*Query queryLoggedOnUser = sess.createQuery("from User where username = :username");
        queryLoggedOnUser.setParameter("username", userName);*/
        
        //use Criteria to fetch the logged on user and check if it exists in the DB 
        Criteria cr = sess.createCriteria(User.class);
        cr.add(Restrictions.eq("username", userName));
        ArrayList<User> queryLoggedOnUser = (ArrayList<User>) cr.list();
        currentLoggedOnUser = (ArrayList<User>) queryLoggedOnUser;
        for(User u : currentLoggedOnUser) {
        	System.out.println("Criteria: " + u.getUsername() + " - " + u.getPassword());
        }
        
        //set the currentLoggedOnUser variable in the session so it can be acessed in welcome-user.jsp
        //HttpSession session = request.getSession();
        request.setAttribute("currentLoggedOnUser", currentLoggedOnUser);
        
        /*Query queryUsers = sess.createQuery("from User");
        listUsers = (ArrayList<User>) queryUsers.list();*/
		
        //native query in hibernate
        Query queryUsers = sess.createNativeQuery("select * from user")
		.addEntity(User.class);
		ArrayList<User> listUsers = (ArrayList<User>) queryUsers.list();
        for(User u : listUsers) {
        	System.out.println("Native: " + u.getUsername() + " - " + u.getPassword());
        }
        
        //set the listUser variable in the session so it can be acessed in the UserManagementView
        request.setAttribute("listUsers", listUsers);
        
     	System.out.println("########## EMPLOYEES ##########");
        
   	    Query queryEmployee = sess.createQuery("from Employee");
        listEmployee = (ArrayList<Employee>) queryEmployee.list();
        for(Employee e : listEmployee) {
        	System.out.println(e.getEmployeeId() + " - " + e.getFirstName() + " - " + e.getLastName() + " - "
        	+ e.getCountry() + " - " + e.getAddress() + " - " + e.getRole());
        }
        
        //set the listEmployee variable in the session so it can be acessed in the EmployeeView
        request.setAttribute("listEmployee", listEmployee);
        
        System.out.println("########## SALARY ##########");
        
   	    Query querySalary = sess.createQuery("from Salary");
        listSalary = (ArrayList<Salary>) querySalary.list();
        for(Salary s : listSalary) {
        	System.out.println(s.getEmployeeId() + " - " + s.getFirstName() + " - " + s.getLastName() + " - "
        	+ s.getStep() + " - " + s.getValue());
        }
        
        //set the listSalary variable in the session so it can be acessed in the SalaryView
        request.setAttribute("listSalary", listSalary);
        
        
        System.out.println("End of welcome user action");
        
        
        sess.getTransaction().commit();
        sess.close();
        
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
    
    public void setListUsers(ArrayList<User> listUsers) {
    	this.listUsers = listUsers;
    }
    
    public void setListEmployee(ArrayList<Employee> listEmployee) {
    	this.listEmployee = listEmployee;
    }
    
    public void setCurrentLoggedOnUser(ArrayList<User> currentLoggedOnUser) {
    	this.currentLoggedOnUser = currentLoggedOnUser;
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
    
    public ArrayList<User> getListUsers() {
    	return listUsers;
    }
    
    public ArrayList<Employee> getListEmployee() {
    	return listEmployee;
    }
    
    public ArrayList<User> getCurrentLoggedOnUser() {
    	return currentLoggedOnUser;
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
