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

public class DetailEmployeeViewServlet extends HttpServlet {

	public static final long serialVersionUID = 30L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final ArrayList<Employee> listEmployee;
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
    	
    	Query queryEmployee = sess.createQuery("from Employee");
        listEmployee = (ArrayList<Employee>) queryEmployee.list();
        for(Employee e : listEmployee) {
        	System.out.println(e.getEmployeeId() + " - " + e.getFirstName() + " - " + e.getLastName() + " - "
        	+ e.getCountry() + " - " + e.getAddress() + " - " + e.getDepartment());
        }
        
        //set the listEmployee variable with the updated query values (the user just created or updated an employee)
        //in the request so it can be acessed in the EmployeeView
        request.setAttribute("listEmployee", listEmployee);
		
		System.out.println("In doGet DetailEmployeeViewServlet");
        request.getRequestDispatcher("/WEB-INF/content/DetailEmployeeView.jsp").forward(request, response);
        
    }
	
}
