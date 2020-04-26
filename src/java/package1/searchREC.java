/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aishw
 */
@WebServlet(name = "searchREC", urlPatterns = {"/searchREC"})
public class searchREC extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
              out.println(" <nav class=\"navbar navbar-inverse\">\n" +
"  <div class=\"container-fluid\">\n" +
"    <div class=\"navbar-header\">\n" +
"      <a class=\"navbar-brand\" href=\"#\">Bank</a>\n" +
"    </div>\n" +
"    <ul class=\"nav navbar-nav\">\n" +
"      <li ><a href=\"details\">Welcome Admin</a></li>\n" +
"      <li><a href=\"LoanApps\">Loan Applications</a></li>\n" +
 "      <li><a href=\"LoanAppDet\">Loan Application Details</a></li>\n" +
"      <li><a href=\"custInfo\">Customer Information</a></li>\n" +
"      <li><a href=\"ViewRates.jsp\">Rates</a></li>\n" +
"      <li class=\"active\"><a href=\"#\">Recieved EMIs</a></li>\n" +
"      <li><a href=\"calcEMI1\">Calculate Emi</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
             Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
            int cid=Integer.parseInt(request.getParameter("cid"));
            Query query = session.createQuery("SELECT COUNT(*) FROM EMI2 emi where emi.CID=:CID");
  query.setParameter("CID",cid);
          Long count=(Long) query.uniqueResult();
          if(count==0){
              
              out.println("<center><h1>No records of the customer!</h1>");
              out.println("<form action='RecEMI'>");
              out.println("<input type='submit' value='go back'>");
              out.println("</form></center>");
          }
          else{
             List emiPs=session.createQuery("FROM RecieveEmi R where R.CID=:CID").setParameter("CID", cid).list();
             out.println("<center>");
             out.println("<div class=\"container\">");
             out.println("<table class='table table-hover'>");
           out.println("<tr>");
           out.println("<th>Customer id</th><th>No.of.payments</th><th>Reciept date</th><th>EMI date</th>");
           out.println("<th>EMI amount</th><th>Late fine charge</th><th>Total Amount</th>");
           out.println("</tr>");
           for (Iterator iterator = emiPs.iterator(); iterator.hasNext();){
               RecieveEmi fix=(RecieveEmi) iterator.next();
               out.println("<tr>");
               out.println("<td>"+fix.getCID()+"</td>");
               out.println("<td>"+fix.getNoOfPayment()+"</td>");
               out.println("<td>"+fix.getRecieptDate()+"</td>");
               out.println("<td>"+fix.getEMIDate()+"</td>");
               out.println("<td>"+fix.getEMIAmount()+"</td>");
               out.println("<td>"+fix.getLateFineCharge()+"</td>");
               out.println("<td>"+fix.getTotalAmount()+"</td>");
                out.println("</tr>");
           }
           out.println("</table></div>");
            out.println("<form action='RecEMI'>");
              out.println("<input type='submit' value='go back'>");
              out.println("</form>");
           out.println("</center>");
          }
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
