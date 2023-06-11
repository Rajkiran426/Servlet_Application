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
@WebServlet("/vefiryLogin")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login_Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		DAoService service=new DAOServiceImpl();
		service.ConnectBD();
		
		
		
		boolean status = service.VerifyCredencial(email, password);
		if(status==true) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("email",email);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "UserName/Password Invaild!");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		service.CloseConnection();
	}

}
