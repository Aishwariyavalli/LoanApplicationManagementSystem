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
@WebServlet(name = "calcEMI1", urlPatterns = {"/calcEMI1"})
public class calcEMI1 extends HttpServlet {

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
            List emis=null;
            emis=session.createQuery("From EMI2").list();
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
"      <li><a href=\"RecEMI\">Recieved EMIs</a></li>\n" +
"      <li class=\"active\"><a href=\"#\">Calculate Emi</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
            out.println("<Center>");
            out.println("<br/>");
            out.println("<h2>Calculate EMI:</h2>");
            out.println("<form action=''>");
            out.println("Customer ID:");
            out.println("<br/>");
            out.println("<input type='number' name='cid'/ required>");
            out.println("<br/>");
            out.println("Loan-Amount:");
            out.println("<br/>");
            out.println("<input type=\"number\" name=\"LoanAmt\" placeholder=\"1.0\" step=\"0.01\" min=\"0\" required>");
            out.println("<br/>");
            out.println("Loan Tenure(in months):");
            out.println("<br/>");
            out.println("<input type='number' name='LoanTenure' required>");
            out.println("<br/>");
            out.println("Annual Interest rate:");
            out.println("<br/>");
            out.println("<input type=\"number\" name=\"InterestR\" placeholder=\"1.0\" step=\"0.01\" min=\"0\" required>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<input type='submit' value='calculate'/>");
            out.println("</form>");
            String id=request.getParameter("cid");
            if(id!=null){
                int cid=Integer.parseInt(request.getParameter("cid"));
                Query query = session.createQuery("SELECT COUNT(*) FROM CustMaster c where c.CID=:CID");
  query.setParameter("CID",cid);
          Long count=(Long) query.uniqueResult();
          if(count==0){
              
              response.sendRedirect("error1.html");
              
          }
                float principal=Float.parseFloat(request.getParameter("LoanAmt"));
            int time=Integer.parseInt(request.getParameter("LoanTenure"));
            float rate=Float.parseFloat(request.getParameter("InterestR"));
            rate=rate/(12*100);
            float emi=(principal*rate*(float)Math.pow(1+rate,time))/(float)(Math.pow(1+rate,time)-1);
            float tot=emi*time;
            float interest=tot-principal;
               out.println("<form action='EMIsub' method='post'>");
               out.println("customer-id:");
               out.println("<br/>");
               out.println("<input type='number' name='cid' value= '"+ cid+"'required/>");
               out.println("<br/>");
               out.println("EMI amount:");
               out.println("<br/>");
               out.println("<input type='number' name='emi' value= '"+Math.round(emi)+"' required/>");
               out.println("<br/>");
               out.println("Total amount:");
               out.println("<br/>");
               out.println("<input type='number' step='0.01' min='0' name='tot' value= '"+ Math.round(tot)+"' required/>");
               out.println("<br/>");
               out.println("Interest amount:");
               out.println("<br/>");
               out.println("<input type='number' step='0.01' min='0' name='interest' value= '"+Math.round(interest) +"' required/>");
               out.println("<br/><br/>");
               out.println("<input type='submit' value='Add'>");
               out.println("</form>");
            }
            else{
                 out.println("<form action='EMIsub' method='post'>");
                 out.println("customer-id:");
               out.println("<br/>");
               out.println("<input type='number' name='cid1' required/>");
               out.println("<br/>");
               out.println("EMI amount:");
               out.println("<br/>");
               out.println("<input type='number' step='0.01' min='0' name='emi' required/>");
                out.println("<br/>");
               out.println("Total amount:");
               out.println("<br/>");
               out.println("<input type='number' step='0.01' min='0' name='tot' required/>");
                out.println("<br/>");
               out.println("Interest amount:");
               out.println("<br/>");
               out.println("<input type='number' step='0.01' min='0' name='interest' required/>");
               out.println("<br/><br/>");
               out.println("<input type='submit' value='Add'>");
               out.println("</form>");
            }
         
               out.println("<div class=\"container\">");
            out.println("<table class=\"table table-hover\">");
            out.println("<tr>\n" +
"                    <th>Customer Id</th>\n" +
"                    <th>EMI amount</th>\n" +
"                    <th>Interest amount</th>\n" +
"                    <th>Total amount</th>\n" +
"                    <th>Action</th>\n" +
"                </tr>");
            for (Iterator iterator = emis.iterator(); iterator.hasNext();){
                EMI2 emi1=(EMI2) iterator.next();
                out.println("<tr>");
                out.println("<td>"+emi1.getCID()+"</td>");
               out.println("<td>"+emi1.getEMIAmount()+"</td>");
               out.println("<td>"+emi1.getInterestAmount()+"</td>");
               out.println("<td>"+emi1.getTotalAmount()+"</td>");
               out.println("<td>"+"<a href='delete1?id="+emi1.getID()+"'>Delete</a>");
               
            }
            out.println("</table></div></Center>");
            
            
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
