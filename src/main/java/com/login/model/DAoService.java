package com.login.model;

import java.sql.ResultSet;

public interface DAoService {
	public void ConnectBD();

	public boolean VerifyCredencial(String email, String password);

	public void newRegister(String name, String city, String email, String mobile);

	public ResultSet readAll();

	public void deleteByEmail(String email);

	public void updateRegistration(String email, String mobile);

	public void CloseConnection();

}
