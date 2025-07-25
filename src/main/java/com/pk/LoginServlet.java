package com.pk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("tbname");
		String pass = request.getParameter("tbpass");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Jsp","root","219f1a05a4");
			PreparedStatement pst = con.prepareStatement("Select * from login where username=? and password=?");
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				response.sendRedirect("home.jsp?user="+user);
			}else {
				response.getWriter().println("Invalid Credentials");
			}
					
		}catch(Exception e) {
			response.getWriter().println("Login Failed");
		}
		
	}

}
