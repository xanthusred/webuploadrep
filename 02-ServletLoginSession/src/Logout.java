

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	//FilterChain chain=null;
//		out.println("hi");
	HttpSession session=request.getSession(false);
	request.getSession(false).invalidate();
	response.sendRedirect("Index.html");
	
//	if (request.getSession(false).getAttribute("Username") == null) {
//        response.sendRedirect("Index.html"); // No logged-in user found, so redirect to login page.
//    } else {
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setDateHeader("Expires", 0);
//        chain.doFilter(request, response);  
//    }
	}
	

}
