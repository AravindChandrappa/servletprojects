package com.login.in.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public RegisterServlet() {
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("invoked RegisterServlet doget() method");
		/*PrintWriter  printWriter=response.getWriter();
		printWriter.println("hello");
		*/
		String fName=request.getParameter("fname");
		String lName=request.getParameter("lname");
		String uName=request.getParameter("uname");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String pass=request.getParameter("pass");
		String cPass=request.getParameter("cpass");
		//PreparedStatement pInsertRid;
		
		String query="insert into aravind.login values('"+fName+"','"+lName+"','"+uName+"','"+email+"','"+gender+"','"+pass+"','"+cPass+"')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind","root","dinga");
			//pInsertRid = connection.prepareStatement(INSERT_OID_SQL, Statement.RETURN_GENERATED_KEYS);
			Statement statement=connection.createStatement();
			int b=statement.executeUpdate(query);
			
			if(b>0)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
			}
			else
			{
				System.out.println("dta is not proper please try again...");
			}
			
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
				
		
		
	}

}
