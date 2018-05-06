/**
 * 
 */
package pt.francisco.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;

import pt.francisco.hibernate.model.Employee;

import javax.servlet.http.HttpServlet;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.User;
import pt.francisco.util.HibernateUtil;

/**
 * @author Francisco
 *
 */

public class UserManagementViewServlet extends HttpServlet {

	public static final long serialVersionUID = 2L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final ArrayList<User> listUsers;
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
    	
    	Query queryUsers = sess.createQuery("from User");
        listUsers = (ArrayList<User>) queryUsers.list();
        for(User u : listUsers) {
        	System.out.println(u.getUsername() + " - " + u.getPassword());
        }
        
        //set the listUser variable with the updated query values (the admin just created or updated a user)
        //in the request so it can be acessed in the UserManagementView
        request.setAttribute("listUsers", listUsers);
		
		System.out.println("In doGet UserManagementViewServlet");
        request.getRequestDispatcher("/WEB-INF/content/UserManagementView.jsp").forward(request, response);
        
    }

	//Postprocess request: here we want to pass the employee list to the Employee.jsp so we can display it there
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        final ArrayList<User> listUsers;
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
    	
    	System.out.println("In doPost UserManagementViewServlet");
    	Query queryUsers = sess.createQuery("from User");
        listUsers = (ArrayList<User>) queryUsers.list();
        for(User u : listUsers) {
        	System.out.println(u.getUsername() + " - " + u.getPassword());
        }
        
        //set the listUser variable with the updated query values (the admin just created or updated a user)
        //in the request so it can be acessed in the UserManagementView
        request.setAttribute("listUsers", listUsers);
        
    	request.getRequestDispatcher("/WEB-INF/content/UserManagementView.jsp").forward(request, response);
        
    }
	
}
