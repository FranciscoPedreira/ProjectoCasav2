package pt.francisco.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeUserServlet extends HttpServlet {
	
	public static final long serialVersionUID = 3L;
	
	//Preprocess the request
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered doGet() WelcomeUserServlet");
        //request.getRequestDispatcher("/WEB-INF/content/EmployeeView.jsp").forward(request, response);
        
    }

	//Postprocess the request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	HttpSession session = (HttpSession) request.getSession();
    	request.setAttribute("listEmployee", session.getAttribute("listEmployee"));
    	System.out.println("WelcomeUserActionServlet: listEmployee = " + session.getAttribute("listEmployee"));
        /*request.setAttribute("testPostProcessVar", "I came from doPost!");
        request.getRequestDispatcher("/WEB-INF/content/EmployeeView.jsp").forward(request, response);*/
        
    }
	
}
