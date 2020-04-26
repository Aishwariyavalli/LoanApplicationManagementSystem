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
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aishw
 */
@WebServlet(name = "LoanAppDet", urlPatterns = {"/LoanAppDet"})
public class LoanAppDet extends HttpServlet {

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
            List loanapps=null;
            loanapps=session.createQuery("From LoanMaster1").list();
            request.setAttribute("loanapps", loanapps);
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
 "      <li class=\"active\"><a href=\"#\">Loan Application Details</a></li>\n" +
"      <li><a href=\"custInfo\">Customer Information</a></li>\n" +
"      <li><a href=\"ViewRates.jsp\">Rates</a></li>\n" +
 "      <li><a href=\"RecEMI\">Recieved EMIs</a></li>\n" +
"      <li><a href=\"calcEMI1\">Calculate Emi</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
                   out.println("<script>\n" +
"function onlyOne(checkbox) {\n" +
"    var checkboxes = document.getElementsByName('names')\n" +
"    checkboxes.forEach((item) => {\n" +
"        if (item !== checkbox) item.checked = false\n" +
"    })\n" +
"}\n" +
"</script>");
            out.println("<Center>");
            out.println("<div class=\"container\">");
           out.println("<table class='table table-hover'>");
            out.println("<tr>");
            out.println("<th>Loan Id</th>");
             out.println("<th>Customer Name</th>");
             out.println("<th>Loan Type</th>");
             out.println("<th>Loan Tenure</th>");
             out.println("<th>Loan Amount</th>");
             out.println("<th>Interest Type</th>");
             out.println("<th>Interest Rate</th>");
             out.println(" <th>Issue Date</th>");
             out.println("<th>Mortgage Details</th>");
             out.println("<th>Guarantor Name</th>");
             out.println("<th>Address</th>");
             out.println("<th>Contact No</th>");
             out.println("<th>Approval Status</th>");
             out.println("<th>Action</th>");
            out.println("</tr>");
            out.println("<form action='edit1.jsp'>");
            for (Iterator iterator = loanapps.iterator(); iterator.hasNext();){
                LoanMaster1 loanapp=(LoanMaster1) iterator.next();
               int id=loanapp.getCID();
                CustMaster cust=(CustMaster)session.createQuery("FROM CustMaster CM where CM.CID=:CID").setParameter("CID", id).uniqueResult();
                int s=loanapp.getApprStatus();
                String stat="";
                if(s==0){
                    stat="pending";
                }
                else if(s==1){
                    stat="approved";
                }
                else{
                    stat="rejected";
                }
                out.println("<tr>");
                out.println("<td>"+loanapp.getLoanId()+"</td>");
                out.println("<td>"+cust.getCustName()+"</td>");
                out.println("<td>"+loanapp.getLoanType()+"</td>");
                out.println("<td>"+loanapp.getLoanTenure()+"</td>");
                out.println("<td>"+loanapp.getLoanAmount()+"</td>");
                out.println("<td>"+loanapp.getInterestType()+"</td>");
                out.println("<td>"+loanapp.getInterestRate()+"</td>");
                out.println("<td>"+loanapp.getIssueDate()+"</td>");
                out.println("<td>"+loanapp.getMortgageDetails()+"</td>");
                out.println("<td>"+loanapp.getGuarantorName()+"</td>");
                out.println("<td>"+loanapp.getAddress()+"</td>");
                out.println("<td>"+loanapp.getContactNo()+"</td>");
                out.println("<td>"+stat+"</td>");
                out.println("<td>"+"<input type=\"checkbox\" name=\"names\" value=\""+ loanapp.getLoanId()+ "\" onclick='onlyOne(this)'/>"+"</td>");
                out.println("</tr>");
            }
           out.println("</table>");
           out.println("<input type='submit' value='Edit'>");
           out.println("<input type='submit' value='Delete' formaction='del1'>");
           out.println("<input type='submit' value='Approve' formaction='appr1'/>");
           out.println("<input type='submit' value='Reject' formaction='rej1'/>");
           out.println("<br/>");out.println("<br/>");
           out.println("<input type='submit' value='get Pie chart analysis of interest rates' formaction='PieChart'/>");
           out.println("</form>");
           out.println("</div>");
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
