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
 * Servlet implementation class DecoderController
 */
@WebServlet("/decode")
public class DecoderController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecoderController() {
        super();
    }

    DecoderService<?> decSer;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the POST method to handle form submission via POST
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UnifiedHandler h = new UnifiedHandler();

        // Retrieve form parameters from POST payload
        String toProcess = request.getParameter("toProcess");
        String email = request.getParameter("email");

        if (toProcess != null) {
            h.setT(toProcess);

            // Retrieve the DecoderService based on the email
            DecoderService<?> decSer = (DecoderService<?>) h.getObjectForDecoding(email);
            if (decSer == null) {
                System.out.println("No DecoderService object found.");
            } else {
                // Decode the provided input 
                request.setAttribute("decodedMessage", decSer.decode(toProcess));
            }
        } else {
            System.out.println("No 'toProcess' parameter provided.");
        }

        request.setAttribute("message", "Decoding completed!");
        request.getRequestDispatcher("/WEB-INF/views/viewDecode.jsp").forward(request, response);
    }
}
