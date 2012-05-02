/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mock.sample.annotations.ExternalService;
import org.mock.sample.annotations.MaxNumber;
import org.mock.sample.cdi.GreetService;
import org.mock.sample.ejbs.GreetBean;

/**
 *
 * @author behera
 */
@WebServlet(name = "GreeterServlet", urlPatterns = {"/greeter"})
public class GreeterServlet extends HttpServlet {

    @EJB private GreetBean greetBean;
    @Inject private GreetService greetService;
    @Inject @ExternalService private GreetService greet;
    @MaxNumber @Inject private int maxNumber;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String ejbMSG = greetBean.greet("demo");
        String cdiMSG = greetService.greetCDI("demo");
        String extCDIMSG = greet.greetCDI("demo");
        greetBean.longRunningAction();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GreeterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>Servlet ejbMSG " + ejbMSG + "</h4>");
            out.println("<h4>Servlet cdiMSG " + cdiMSG + "</h4>");
            out.println("<h4>Servlet extCDIMSG " + extCDIMSG + "</h4>");
            out.println("<h4>Servlet max number " + maxNumber + "</h4>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
