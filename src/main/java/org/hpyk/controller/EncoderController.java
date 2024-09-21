package org.hpyk.controller;

import java.io.File;
import java.io.IOException;

import org.hpyk.model.handler.impl.UnifiedHandler;
import org.hpyk.service.EncoderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/encode")
public class EncoderController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private EncoderService<?> enSer;
	String str ="test";
	File f = new File("C:\\Users\\Harsh\\eclipse-workspace\\SecureFiles\\src\\main\\webapp\\WEB-INF\\web.xml");
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		
		String receverEmail = request.getParameter("email");
		if(receverEmail!=null) {
		
		UnifiedHandler h = new UnifiedHandler();
		Object toEncode = request.getParameter("toEncode");
		String email = request.getParameter("email");
		 if (toEncode != null) {
		        // Set the parameter to the handler (can be any type)
		        h.setT(toEncode); 
		        enSer= (EncoderService<?>) h.getObjectForEncoding(email);
		        request.setAttribute("encodedResult", enSer.encode(toEncode));
		
		 }
		System.out.println(enSer==null?"No input found":enSer.getClass().getName());
		System.out.println(enSer==null?"No input found":enSer.encode(toEncode));
		}
        request.setAttribute("message", "Welcome to My Web Application!");
        request.getRequestDispatcher("/WEB-INF/views/viewEncode.jsp").forward(request, response);
    }
	
}
