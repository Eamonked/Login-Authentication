package all;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class loginAuthenticatorServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform authentication
        if (isValidUser(username, password)) {
            // Set session attribute and redirect to home page
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.html");
        } else {
            // Display error message and redirect back to login page
            request.setAttribute("error", "Invalid username or password");
            RequestDispatcher rd = request.getRequestDispatcher("error.html");
            rd.forward(request, response);
        }
    }
	private boolean isValidUser(String username, String password) {
	    // Check if the username and password are "admin"
	    return username.equals("admin") && password.equals("admin");
	}

}
