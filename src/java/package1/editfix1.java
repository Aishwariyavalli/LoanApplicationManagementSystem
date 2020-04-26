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
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aishw
 */
@WebServlet(name = "editfix1", urlPatterns = {"/editfix1"})
public class editfix1 extends HttpServlet {

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
            /*Cookie [] cookies=request.getCookies();
           String id=cookies[0].getValue();*/
            HttpSession s=request.getSession();
           int id1=(int)s.getAttribute("fix");
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
             Fixed fix= (Fixed)session.get(Fixed.class, id1);
             String typeloan=request.getParameter("typeloan");
             String loanTenure=request.getParameter("duration");
             String loanAmt=request.getParameter("Rate");
            /* out.println(typeloan);
             out.println(custName);
             out.println(Gender);
             out.println(MobileNo);*/
            if(typeloan.equals("Gold Loan")){
             fix.setLoanType("Gold Loan");}
            else if(typeloan.equals("Car Loan")){
                 fix.setLoanType("Car Loan");}
            else if(typeloan.equals("Education Loan")){
                 fix.setLoanType("Education Loan");}
            else{
                fix.setLoanType("House Loan");
            }
             fix.setDuration(loanTenure);
             fix.setRate(Float.parseFloat(loanAmt));
             session.update(fix);
             tx.commit();
             response.sendRedirect("fixedRates");
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
