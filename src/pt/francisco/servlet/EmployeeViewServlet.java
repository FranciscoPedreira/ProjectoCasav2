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

import pt.francisco.hibernate.model.Employee;

import javax.servlet.http.HttpServlet;

/**
 * @author Francisco
 *
 */

public class EmployeeViewServlet extends HttpServlet {

	public static final long serialVersionUID = 2L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    	//request.setAttribute("listEmployee", request.getAttribute("listEmployee"));
    	System.out.println("EmployeeViewServlet: listEmployee = " + request.getAttribute("listEmployee"));
        request.getRequestDispatcher("/WEB-INF/content/EmployeeView.jsp").forward(request, response);
        
    }

	//Postprocess request: here we want to pass the employee list to the Employee.jsp so we can display it there
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
        /*request.setAttribute("testPostProcessVar", "I came from doPost!");
        request.getRequestDispatcher("/WEB-INF/content/EmployeeView.jsp").forward(request, response);*/
        
    }
	
}
