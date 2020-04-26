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
import javax.servlet.http.Cookie;
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
@WebServlet(name = "upd2", urlPatterns = {"/upd2"})
public class upd2 extends HttpServlet {

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
           int id1=(int)s.getAttribute("lid");
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
             CustMaster loanapp= (CustMaster)session.get(CustMaster.class, id1);
             String custName=request.getParameter("custName");
             String PANNo=request.getParameter("PANNo");
             String gender=request.getParameter("gender");
             String city=request.getParameter("city");
             String addr=request.getParameter("addr");
             String MNo=request.getParameter("MNo");
             String ANo=request.getParameter("ANo");
             String DOB=request.getParameter("DOB");
             String status=request.getParameter("status");
            /* out.println(typeloan);
             out.println(custName);
             out.println(Gender);
             out.println(MobileNo);*/
             loanapp.setCustName(custName);
             loanapp.setPANNo(PANNo);
             loanapp.setGender(gender);
             loanapp.setCity(city);
             loanapp.setAddress(addr);
             loanapp.setMobileNo(Integer.parseInt(MNo));
             loanapp.setAlternateNo(Integer.parseInt(ANo));
             loanapp.setDob(DOB);
             loanapp.setStatus(status);
             session.update(loanapp);
             tx.commit();
             response.sendRedirect("custInfo");
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
