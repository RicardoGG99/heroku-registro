package helpers;


import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//Attributes
	private static String DBurl = "jdbc:postgresql://ec2-50-16-221-180.compute-1.amazonaws.com\r\n" + 
			":5432/dfc6f6qc9b8loj";
	private static String DBuser = "spddzptnewmwch";
	private static String DBpassword = "006214d7c716e2f6d5176b62d485ee3f2f19d09b74f4b52e96795b2e06c28d02";
	private static String DBdriver = "org.postgresql.Driver";
	private static Connection conn = null;
	
	//Methods

	public Connection getConnection() {
		try {
			if(conn == null) {
			Class.forName(DBdriver);
			conn = DriverManager.getConnection(DBurl, DBuser, DBpassword);
			System.out.println("Conexion Exitosa");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}


