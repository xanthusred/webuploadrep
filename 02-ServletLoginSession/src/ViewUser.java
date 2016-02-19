

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		String vu=request.getParameter("viewuser");
		if(vu.equals("viewuser")){
		
			String sss= (String)request.getSession(false).getAttribute("isvalid");
			
			if(sss.equals("true")){
				out.println("Welcome  "+request.getSession(false).getAttribute("Username"));
				out.println("<html><body><form action=./Logout method=post>");
				out.println("<input type=submit name=logout value=logout />");
				out.println("</form></body></html>");
			}
			else
			{
				out.println("invalidated session");
			}
			
		}
		else{
			out.println("invalidated session");
		}
		
		
	}

}
