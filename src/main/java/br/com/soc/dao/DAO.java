package br.com.soc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DAO {

	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=SOC;integratedSecurity=true";
	private static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=SOC;user=soc_user;password=123456";

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName(DRIVER);
		}
		catch (ClassNotFoundException e) { }
		
		return DriverManager.getConnection(CONNECTIONURL);
	}
}
