package com.xworkz.spring.components;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.spring.dao.PostOfficeDAO;
import com.xworkz.spring.dto.PostOfficeDTO;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("invoked a fetch method");
		PrintWriter out=response.getWriter();
		String pincode=request.getParameter("pincode");
		int pincode1=Integer.parseInt(pincode);
		
		System.out.println("looking for spring container");
		
		ApplicationContext container=new ClassPathXmlApplicationContext("resources/spring.xml");
		PostOfficeDAO dao=container.getBean(PostOfficeDAO.class);
		
		List<PostOfficeDTO> fetchAllDto=dao.fetchByPincode(pincode1);
		
		if(fetchAllDto!=null)
		{
			out.println(fetchAllDto);
			System.out.println("Data is found with your pincode have a look at browser");
			//out.println("<html><body><a href=\"register.html\">Click Here For Register</a></body><html>");
		}
		else
		{
			out.println("data is not available on thi pin");
		}
		
	}

}
