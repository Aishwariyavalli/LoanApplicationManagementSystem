/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aishw
 */
@WebServlet(name = "addREC3", urlPatterns = {"/addREC3"})
public class addREC3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
           int cid=Integer.parseInt(request.getParameter("cid"));
           int NoofP=Integer.parseInt(request.getParameter("NoofP"));
           String RDate=request.getParameter("RDate");
           String EDate=request.getParameter("EDate");
           float EMIAmt=Float.parseFloat(request.getParameter("EMIAmt"));
           float LFC=Float.parseFloat(request.getParameter("LFC"));
           float totalAmt=EMIAmt+LFC;
           RecieveEmi R=new RecieveEmi();
           R.setCID(cid);
           R.setNoOfPayment(NoofP);
           R.setRecieptDate(RDate);
           R.setEMIDate(EDate);
           R.setEMIAmount(EMIAmt);
           R.setLateFineCharge(LFC);
           R.setTotalAmount(totalAmt);
           session.save(R);
           tx.commit();
           response.sendRedirect("RecEMI");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
