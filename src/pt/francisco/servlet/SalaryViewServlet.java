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
import pt.francisco.hibernate.model.Salary;

import javax.servlet.http.HttpServlet;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import pt.francisco.hibernate.model.Employee;
import pt.francisco.hibernate.model.User;
import pt.francisco.hibernate.util.HibernateUtil;

/**
 * @author Francisco
 *
 */

public class SalaryViewServlet extends HttpServlet {

	public static final long serialVersionUID = 2L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doGet SalaryViewServlet");
        request.getRequestDispatcher("/WEB-INF/content/SalaryView.jsp").forward(request, response);
        
    }

	//Postprocess request: here we want to pass the employee list to the Employee.jsp so we can display it there
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        final ArrayList<Salary> listSalary;
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
    	
    	System.out.println("In doPost SalaryViewServlet");
    	Query querySalary = sess.createQuery("from Salary");
        listSalary = (ArrayList<Salary>) querySalary.list();
        for(Salary s : listSalary) {
        	System.out.println(s.getId().getFirstName() + " - " + s.getId().getLastName() + " - "
        	+ s.getStep() + " - " + s.getValue());
        }
        
        //set the listSalary variable with the updated query values (the user just created or updated a Salary)
        //in the session so it can be acessed in the SalaryView
        HttpSession session = request.getSession();
        session.setAttribute("listSalary", listSalary);
        
    	request.getRequestDispatcher("/WEB-INF/content/SalaryView.jsp").forward(request, response);
        
    }
	
}
