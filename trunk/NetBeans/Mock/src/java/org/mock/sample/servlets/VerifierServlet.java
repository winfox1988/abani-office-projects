/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mock.sample.ejbs.ServicesBean;

/**
 *
 * @author abani
 */
@WebServlet(name = "VerifierServlet", urlPatterns = {"/async", "/sync"})
public class VerifierServlet extends HttpServlet {

    @EJB
    private ServicesBean servicesBean;

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
        if ("/async".equalsIgnoreCase(request.getServletPath())) {
            processAsyncInvocation(out);
        } else {
            processSyncInvokation(out);
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

    private void processAsyncInvocation(PrintWriter out) {
        servicesBean.sendEmailAsync("abani@osw.in");
        Future<Integer> result = servicesBean.executeComputationAsync("213");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet VerifierServlet</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            int res = result.get();
            out.println("Async result is " + res);
        } catch (InterruptedException ex) {
            Logger.getLogger(VerifierServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(VerifierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</body>");
        out.println("</html>");
    }

    private void processSyncInvokation(PrintWriter out) {
        servicesBean.sendEmail("abani@osw.in");
        int result = servicesBean.executeComputation("213");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet VerifierServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("result is " + result);
        out.println("</body>");
        out.println("</html>");
    }
}
