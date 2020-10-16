package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UserManager;
import helpers.PasswordHashing;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PasswordHashing ph = new PasswordHashing();
    
    public Login() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newPassword = ph.hashPassword(password);
		
		UserManager um = new UserManager();
		
		boolean result = um.login(username, newPassword);
		
		if(result == true) {
			response.sendRedirect("/logged.html");
		}else {
			response.sendRedirect("/notlog.html");
		}
	}

}
