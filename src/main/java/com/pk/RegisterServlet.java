package com.pk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hit")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("tbname");
		String pass = request.getParameter("tbpass");
		String mail=request.getParameter("mail");
		String qual=request.getParameter("qual");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Jsp","root","219f1a05a4");
			PreparedStatement pst= con.prepareStatement("insert into user (username,password,email,qualification) values(?,?,?,?);");
			pst.setString(1, user);
			pst.setString(2, pass);
			pst.setString(3, mail);
			pst.setString(4, qual);
			
			int rows=pst.executeUpdate();
			if(rows>0) {
				response.sendRedirect("login.html");
			}else {
				response.getWriter().println("Registration Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
