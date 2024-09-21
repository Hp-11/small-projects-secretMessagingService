package org.hpyk.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

import org.hpyk.model.handler.impl.UnifiedHandler;
import org.hpyk.service.DecoderService;

/**
 * Servlet implementation class DecoderControllerImpl2
 */
@WebServlet("/decode")
public class DecoderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecoderController() {
        super();
        // TODO Auto-generated constructor stub
    }
    DecoderService<?> decSer;
	String str ="test";
	File f = new File("C:\\Users\\Harsh\\eclipse-workspace\\SecureFiles\\src\\main\\webapp\\WEB-INF\\web.xml");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		UnifiedHandler h = new UnifiedHandler();
		Object toDecode = request.getParameter("toDecode");
		String email = request.getParameter("email");
		
		if (toDecode != null ) {
	        h.setT(toDecode);

	        // Safely retrieve the DecoderService object and handle potential errors
	        DecoderService<?> decSer = (DecoderService<?>) h.getObjectForDecoding(email);
	        if (decSer == null) {
	            System.out.println("No DecoderService object found.");
	        } else {
	            System.out.println("DecoderService class: " + decSer.getClass().getName());
//	            System.out.println("Decoded string: " + decSer.decode(toDecode));

	            request.setAttribute("decodedMessage", decSer.decode(toDecode));
	        }
	    } else {
	        System.out.println("No 'toDecode' parameter provided.");
	    }

		
        request.setAttribute("message", "Welcome to My Web Application!");
        request.getRequestDispatcher("/WEB-INF/views/viewDecode.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
