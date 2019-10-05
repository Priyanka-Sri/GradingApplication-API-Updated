package com.revature.grading.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TeacherLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
        PrintWriter out = response.getWriter();
        
        String json = Controller.Tlogin(UserName, Password);
       out.write(json);
       out.flush();
	}

}
