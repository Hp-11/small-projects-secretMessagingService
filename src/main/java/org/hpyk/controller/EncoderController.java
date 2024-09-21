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
    
    private static final long serialVersionUID = 1L;

    private EncoderService<?> enSer;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Forward to the POST method to handle form submission via POST
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        UnifiedHandler h = new UnifiedHandler();

        // Retrieve form parameters from POST payload
        String toEncode = request.getParameter("toProcess");
        String email = request.getParameter("email");

        if (toEncode != null && email != null) {
            // Set the parameter to the handler (can be any type)
            h.setT(toEncode);
            enSer = (EncoderService<?>) h.getObjectForEncoding(email);

            // Check if EncoderService object exists
            if (enSer == null) {
                System.out.println("No EncoderService object found.");
                request.setAttribute("encodedResult", "Encoding service not found.");
            } else { 
                request.setAttribute("encodedResult",  enSer.encode(toEncode));
                System.out.println("Encoded result: " +  enSer.encode(toEncode));
            }
        } else {
            System.out.println("No 'toProcess' or 'email' parameter provided.");
        }

        request.setAttribute("message", "Encoding process completed.");
        request.getRequestDispatcher("/WEB-INF/views/viewEncode.jsp").forward(request, response);
    }
}
