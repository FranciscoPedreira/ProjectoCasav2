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

public class DetailSalaryViewServlet extends HttpServlet {

	public static final long serialVersionUID = 30L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doGet DetailSalaryViewServlet");
		request.getRequestDispatcher("/WEB-INF/content/DetailSalaryView.jsp").forward(request, response);
        
    }
	
}
