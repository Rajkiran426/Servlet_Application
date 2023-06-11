package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.model.DAOServiceImpl;
import com.login.model.DAoService;
@WebServlet("/register")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewRegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newRegistration.jsp");
			rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAoService service=new DAOServiceImpl();
		service.ConnectBD();
		
		service.newRegister(name,city,email,mobile);
		
		request.setAttribute("msg", "Record is Added !");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
		rd.forward(request, response);
		service.CloseConnection();
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
