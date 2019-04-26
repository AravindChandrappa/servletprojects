package com.xworkz.spring.components;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.spring.dao.PostOfficeDAO;
import com.xworkz.spring.dto.PostOfficeDTO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("RegisterServlet invoked");
	
		System.out.println("invoked a RegisterServlet");
		
		String pincode=request.getParameter("pincode");
		String location=request.getParameter("location");
		String branchName=request.getParameter("branchName");
		String working=request.getParameter("working");
		String woking2=request.getParameter("working");
		
		
		Integer pincodep=Integer.parseInt(pincode);
		/*Boolean boolean1=Boolean.parseBoolean(working);
		Boolean boolean2=Boolean.parseBoolean(woking2);*/
		
		PostOfficeDTO dto=new PostOfficeDTO();
		dto.setBranchName(branchName);
		dto.setPincode(pincodep);
		dto.setLocation(location);
		if("b".equals(working))
		{
			dto.setWorking(true);
		}
		else if("a".equals(woking2))
		{
			dto.setWorking(false);
		}
		
		System.out.println("looking for spring container");
		
		ApplicationContext container=new ClassPathXmlApplicationContext("resources/spring.xml");
		PostOfficeDAO dao=container.getBean(PostOfficeDAO.class);
		
		Integer id=dao.save(dto);
		if(id!=0)
		{
			System.out.println("data saved successfully saved");
			out.println("data saved successfully saved");
		}
		else
		{
			System.out.println("data given is invalid");
			out.println("data given is invalid");
		}

		
	}

}
