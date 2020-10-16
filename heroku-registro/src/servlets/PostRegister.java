package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UserManager;
import helpers.PasswordHashing;

@WebServlet("/register")
public class PostRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PasswordHashing ph = new PasswordHashing();
    UserManager um = new UserManager();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String newPassword = ph.hashPassword(password);
		boolean result = um.insert(username, newPassword, email);
		
		if(result == true) {
			response.sendRedirect("public/views/new.html");
		}else {
			response.sendRedirect("public/views/exist.html");
		}
		System.out.println(username + "\n" + newPassword + "\n" + email);
	}

}
