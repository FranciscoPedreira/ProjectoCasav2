/**
 * 
 */
package pt.francisco.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import pt.francisco.hibernate.model.Salary;
import pt.francisco.util.HibernateUtil;

import javax.servlet.http.HttpServlet;
/**
 * @author Francisco
 *
 */

public class DetailSalaryViewServlet extends HttpServlet {

	public static final long serialVersionUID = 30L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final ArrayList<Salary> currentSalary;
    	
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        
        Integer salaryId = (Integer) request.getAttribute("salaryId");
        
        //get salary details
    	Query querySalary = sess.createQuery("from Salary where salaryId = :salaryId");
    	querySalary.setParameter("salaryId", salaryId);
    	currentSalary = (ArrayList<Salary>) querySalary.list();
        for(Salary s : currentSalary) {
        	System.out.println(s.getSalaryId() + " - " + s.getSalaryGroup() + " - " + s.getValue());
        }
        
        //set variables to be used in the view
        request.setAttribute("salaryId", currentSalary.get(0).getSalaryId());
        request.setAttribute("salaryGroup", currentSalary.get(0).getSalaryGroup());
        request.setAttribute("value", currentSalary.get(0).getValue());
		
        sess.getTransaction().commit();
		sess.close();
		
		System.out.println("In doGet DetailSalaryViewServlet");
		request.getRequestDispatcher("/WEB-INF/content/DetailSalaryView.jsp").forward(request, response);
        
    }
	
	//adicionado aqui para o caso em que fazemos remove employee para desassociar o employee ao salary group
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final ArrayList<Salary> currentSalary;
    	
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        
        Integer salaryId = (Integer) request.getAttribute("salaryId");
        
        //get salary details
    	Query querySalary = sess.createQuery("from Salary where salaryId = :salaryId");
    	querySalary.setParameter("salaryId", salaryId);
    	currentSalary = (ArrayList<Salary>) querySalary.list();
    	for(Salary s : currentSalary) {
        	System.out.println(s.getSalaryId() + " - " + s.getSalaryGroup() + " - " + s.getValue());
        }
        
        //set variables to be used in the view
        request.setAttribute("salaryId", currentSalary.get(0).getSalaryId());
        request.setAttribute("salaryGroup", currentSalary.get(0).getSalaryGroup());
        request.setAttribute("value", currentSalary.get(0).getValue());
		
        sess.getTransaction().commit();
		sess.close();
		
		System.out.println("In doPost DetailSalaryViewServlet");
		request.getRequestDispatcher("/WEB-INF/content/DetailSalaryView.jsp").forward(request, response);
        
    }
	
}
