package com.login.in.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("invoked a LoginServlet doget() method");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		String query="select email,pass from aravind.login where email='"+email+"' and pass='"+pass+"' ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind","root","dinga");
			//pInsertRid = connection.prepareStatement(INSERT_OID_SQL, Statement.RETURN_GENERATED_KEYS);
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			if(resultSet.next())
			{
				System.out.println("successfully login");
				RequestDispatcher dispatcher=request.getRequestDispatcher("temp.html");
				dispatcher.forward(request, response);
			}
			else
			{
				System.out.println("not successfull");
				RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}	

}
