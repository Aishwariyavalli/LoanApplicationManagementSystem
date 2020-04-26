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
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aishw
 */
@WebServlet(name = "edit2", urlPatterns = {"/edit2"})
public class edit2 extends HttpServlet {

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
           String[] selectedStudentIds = request.getParameterValues("names");
           int id=Integer.parseInt(selectedStudentIds[0]);
           Cookie ck=new Cookie("loanid",selectedStudentIds[0]);
           response.addCookie(ck);
           CustMaster loanapp=(CustMaster)session.createQuery("FROM CustMaster c where c.CID=:CID").setParameter("CID", id).uniqueResult();
          
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
"      <li class=\"active\"><a href=\"LoanAppDet\">Loan Application Details</a></li>\n" +
"      <li><a href=\"custInfo\">Customer Information</a></li>\n" +
"      <li><a href=\"ViewRates.jsp\">Rates</a></li>\n" +
"      <li><a href=\"RecEMI\">Recieved EMIs</a></li>\n" +
"      <li><a href=\"calcEMI1\">Calculate Emi</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
           out.println("<center>");
           out.println("<h1>UPDATE DETAILS</h1>");
           out.println("<form action='upd2'>");
            out.println("<br/>");
           out.println("Customer Name:");
           out.println("<br/>");
           out.println("<input type='text' name='custName' value='"+loanapp.getCustName()+"'/>");
           out.println("<br/>");
           out.println("PAN No:");
           out.println("<br/>");
           out.println("<input type='text' name='PANNo' value='"+loanapp.getPANNo()+"'/>");
           out.println("<br/>");
           out.println("Gender:");
           out.println("<br/>");
           out.println("<select id='gender' name='gender'>");
           out.println("<option value='Male'>Male"+"</option>");
           out.println("<option value='Female'>Female"+"</option>");  
           out.println("</select>");
           out.println("<br/>");
           out.println("City:");
           out.println("<br/>");
           out.println("<input type='text' name='city' value='"+loanapp.getCity()+"'/>");
           out.println("<br/>");
           out.println("Address:");
           out.println("<br/>");
           out.println("<input type='text' name='addr' value='"+loanapp.getAddress()+"'/>");
           out.println("<br/>");
           out.println("Mobile No:");
           out.println("<br/>");
           out.println("<input type='text' name='MNo' value='"+loanapp.getMobileNo()+"'/>");
           out.println("<br/>");
           out.println("Alternate No:");
           out.println("<br/>");
           out.println("<input type='text' name='ANo' value='"+loanapp.getAlternateNo()+"'/>");
           out.println("<br/>");
           out.println("Date Of birth");
           out.println("<br/>");
           out.println("<input type='text' name='DOB' value='"+loanapp.getDob()+"'/>");
           out.println("<br/>");
           out.println("Status:");
           out.println("<br/>");
           out.println("<select id='status' name='status'>");
           out.println("<option value='active'>active"+"</option>");
           out.println("<option value='Inactive'>Inactive"+"</option>");  
           out.println("</select>");
           out.println("<br/><br/>");
           out.println("<input type='submit' value='Update'/>");
           out.println("<br/>");
           out.println("</form>");
           out.println("</center>");
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
