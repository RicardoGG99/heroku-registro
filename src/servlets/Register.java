package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UserManager;
import helpers.PasswordHashing;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PasswordHashing ph = new PasswordHashing();
	
    public Register() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String newPassword = ph.hashPassword(password);
		
		UserManager um = new UserManager();
		
		boolean result = um.register(username, newPassword, email);
		
		if(result == true) {
			response.sendRedirect("public/views/new.html");
		}else {
			response.sendRedirect("public/views/exist.html");
		}
	}

}
