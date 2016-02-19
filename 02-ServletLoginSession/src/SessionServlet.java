

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean stt;
		PrintWriter out = response.getWriter();
		//out.println("hai");
		
		String isvalid=null;
		String unames=request.getParameter("uname");
		String pwds=request.getParameter("pwd");
		String strs=request.getParameter("submit");
		if(strs.equals("submit"))
		{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        java.sql.Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","system");
        PreparedStatement pst =conn.prepareStatement("select * from user_login where uname=? and pwd=?");
        pst.setString(1,unames);
        pst.setString(2,pwds);
        ResultSet rst =pst.executeQuery();
        stt = rst.next();
        if(stt==true)
        {
        		//out.println("login successfull");
        		isvalid="true";
        		HttpSession session= request.getSession(true);
        		session.setAttribute("Username", unames);
        		session.setAttribute("isvalid",isvalid);
        		response.sendRedirect("viewuser.html");
        		
        
        		
        }
		
		}
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally {            
            out.close();
        }
	}else
	{
		out.println("please go back and enter correct details");
	}
		
		}
	
}