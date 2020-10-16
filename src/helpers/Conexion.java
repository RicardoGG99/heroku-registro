package helpers;


import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//Attributes
	private static String DBurl = "jdbc:postgresql://localhost:5432/postgres";
	private static String DBuser = "postgres";
	private static String DBpassword = "masterkey";
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


