package com.login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAoService {
	private Connection con;
	private Statement stmt;

	@Override
	public void ConnectBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","root");
			stmt=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean VerifyCredencial(String email, String password) {
		try {
			ResultSet res = stmt.executeQuery("SELECT * FROM login WHERE email='"+email+"'and password='"+password+"'");
			return res.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void newRegister(String name, String city, String email, String mobile) {
		try {
			stmt.executeUpdate("INSERT INTO registration VALUES('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet readAll() {
		try {
			ResultSet res = stmt.executeQuery("SELECT * FROM registration");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			stmt.executeUpdate("DELETE FROM registration WHERE email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmt.executeUpdate("UPDATE registration SET mobile='"+mobile+"' WHERE email='"+email+"' ");
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	@Override
	public void CloseConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
