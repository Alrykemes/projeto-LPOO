package com.managepro.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class MySQLRepository implements Repository, ClientRepository, EmployeeRepository, 
StatisticRepository, ProductRepository, SaleRepository {

	private static Connection Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ManagePro_BD", "root", "Senha do Seu LocalHost");
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return Connection();
	}
	
}