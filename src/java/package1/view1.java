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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aishw
 */
@WebServlet(name = "view1", urlPatterns = {"/view1"})
public class view1 extends HttpServlet {

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
            List loans=null;
            loans=session.createQuery("From StudentLoans").list();
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
            out.println("<nav class=\"navbar navbar-inverse\">\n" +
"  <div class=\"container-fluid\">\n" +
"    <div class=\"navbar-header\">\n" +
"      <a class=\"navbar-brand\" href=\"#\">Bank</a>\n" +
"    </div>\n" +
"    <ul class=\"nav navbar-nav\">\n" +
"      <li><a href=\"index.html\">Home</a></li>\n" +
"      <li class=\"active\"><a href=\"#\">Login</a></li>\n" +
"      <li><a href=\"requests.jsp\">View pending requests</a></li>\n" +
"      <li><a href=\"approved.jsp\">View approved requests</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
            out.println("<Center>");
            out.println("<div class=\"container\">");
           out.println("<table class='table table-hover'>");
            out.println("<tr><th style='text-align:center'>Request ID</th><th style='text-align:center'>Full Name</th><th style='text-align:center'>Age</th><th style='text-align:center'>Institute Name</th><th style='text-align:center'>Course name</th><th style='text-align:center'>Loan amount</th><th style='text-align:center'>status</th></tr>");
             for (Iterator iterator = loans.iterator(); iterator.hasNext();)
             {
                 StudentLoans sl=(StudentLoans) iterator.next();
                 Customer c=sl.getCustomer();
                 int id=sl.getRequestId();
                 Cookie ck= new Cookie("custid", Integer.toString(id));
                 response.addCookie(ck);
                 
                 int status=sl.getStatus();
                 String stat="";
                 if(status==0)
                 {
                     stat="<a href='approve1'>Approve</a> &nbsp; <a href='reject1'>Reject</a>";
                 }
                 else if(status==1){
                     stat="approved";
                 }
                 else{
                     stat="rejected";
                 }
                 out.println("<tr>");
                 out.println("<td style='text-align:center'>"+sl.getRequestId()+"</td>");
                 out.println("<td style='text-align:center'>"+c.getFirstName()+" "+c.getLastName()+"</td>");
                 out.println("<td style='text-align:center'>"+sl.getAge()+"</td>");
                 out.println("<td style='text-align:center'>"+sl.getInstituteName()+"</td>");
                 out.println("<td style='text-align:center'>"+sl.getCourse()+"</td>");
                 out.println("<td style='text-align:center'>"+sl.getAmount()+"</td>");
                 out.println("<td style='text-align:center'>"+stat+"</td>");
                out.println("</tr>");
             }
             out.println("</table>");
             out.println("</div>");
             out.println("</Center>");
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
