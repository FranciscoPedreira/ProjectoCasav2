package pt.francisco.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import pt.francisco.hibernate.model.User;
import pt.francisco.util.HibernateUtil;

public class WelcomeUserServlet extends HttpServlet {

	public static final long serialVersionUID = 10L;
	
	//Preprocess the request: since we don't want to do anything when the request comes in we just forward the client to the jsp
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doGet WelcomeUserServlet");
        request.getRequestDispatcher("/WEB-INF/content/welcome-user.jsp").forward(request, response);
        
    }

}
