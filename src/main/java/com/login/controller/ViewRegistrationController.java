package com.login.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.model.DAOServiceImpl;
import com.login.model.DAoService;
@WebServlet("/readAll")
public class ViewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewRegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
		
			DAoService service=new DAOServiceImpl();
			service.ConnectBD();
			
			ResultSet res = service.readAll();
			request.setAttribute("result", res);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/viewRegistration.jsp");
			rd.forward(request, response);
			service.CloseConnection();
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
