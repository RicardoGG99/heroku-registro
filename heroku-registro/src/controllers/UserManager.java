package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helpers.Conexion;
import helpers.PasswordHashing;
import helpers.PropertiesReader;

public class UserManager {
	PropertiesReader properties = new PropertiesReader();
    Conexion conn = new Conexion();
    Connection connection = conn.getConnection();
    PasswordHashing ph = new PasswordHashing();
    PropertiesReader pr = new PropertiesReader();
    
    public boolean insert(String username, String password, String email) {
    	String sentence = "INSERT INTO registro (username, pass, email) VALUES (?, ?, ?)";
		boolean result = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sentence);
			ps = connection.prepareStatement(sentence);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
			result = true; 
			System.out.println(pr.getResult("registro"));
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(pr.getResult("registro"));
		}
		
		return result;
	}
}
