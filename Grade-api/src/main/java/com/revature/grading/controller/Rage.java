package com.revature.grading.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.grading.dao.RangeDao;
import com.revature.grading.dao.RegisterDao;
import com.revature.grading.exception.DBException;
import com.revature.grading.model.Admindetails;
//@WebServlet("/Register")
public class Rage extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Inputs
    	int min11=Integer.parseInt(request.getParameter("min1"));
		int max11=Integer.parseInt(request.getParameter("max1")); 
		String grade11=request.getParameter("grade1");
		
		
		int min22=Integer.parseInt(request.getParameter("min2"));
		int max22=Integer.parseInt(request.getParameter("max2")); 
		String grade22=request.getParameter("grade2");
		
		
		int min33=Integer.parseInt(request.getParameter("min3"));
		int max33=Integer.parseInt(request.getParameter("max3")); 
		String grade33=request.getParameter("grade3");
		
		
		int min44=Integer.parseInt(request.getParameter("min4"));
		int max44=Integer.parseInt(request.getParameter("max4")); 
		String grade44=request.getParameter("grade4");
		
		
		
		PrintWriter out = response.getWriter();
		System.out.println("Minimum Range:" + min11);
	      System.out.println("Maximum Range:" + max11);
	      System.out.println("Grade:" + grade11);
	      
	      
	      System.out.println("Minimum Range:" + min22);
	      System.out.println("Maximum Range:" + max22);
	      System.out.println("Grade:" + grade22);
	      
	      
	      
	      System.out.println("Minimum Range:" + min33);
	      System.out.println("Maximum Range:" + max33);
	      System.out.println("Grade:" + grade33);
	      
	      
	      System.out.println("Minimum Range:" + min44);
	      System.out.println("Maximum Range:" + max44);
	      System.out.println("Grade:" + grade44);
	      
	      
	     
	      
	      
	      String errorMessage = null;
	      
	    //To call dao
	       Admindetails enterdetails=new Admindetails();
	       enterdetails.setMin1(min11);
	       enterdetails.setMax1(max11);
	       enterdetails.setGrade1(grade11);
	       
	       
	       enterdetails.setMin2(min22);
	       enterdetails.setMax2(max22);
	       enterdetails.setGrade2(grade22);
	       
	       enterdetails.setMin3(min33);
	       enterdetails.setMax3(max33);
	       enterdetails.setGrade3(grade33);
	       
	       
	       enterdetails.setMin4(min44);
	       enterdetails.setMax4(max44);
	       enterdetails.setGrade4(grade44);
	       
	      
			 
			System.out.println(enterdetails);
	       try {
	    	   RangeDao.Range( min11,max11,grade11,min22,max22,grade22,  min33,max33,grade33,min44,max44,grade44);

	    	
	       } catch (ClassNotFoundException e) {

			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (SQLException e) {
			
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (DBException e) {
			
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
	       
	    // Convert list to json
	       JsonObject obj = new JsonObject();
	       if (errorMessage != null) {
	    	   obj.addProperty("errorMessage", errorMessage);
	       }
	       else {
	    	   obj.addProperty("message", "Successfully Marks added");
	       }
	       
	       out.write(obj.toString());
	       out.flush();

	       
	}
}












