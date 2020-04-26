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
@WebServlet(name = "Log1", urlPatterns = {"/Log1"})
public class Log1 extends HttpServlet {

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
"      <li ><a href=\"index.html\">Home</a></li>\n" +
"       <li><a href=\"regUser.html\">Register user</a></li>\n" +
"      <li  class=\"active\"><a href=\"custLogin.html\">Customer Login</a></li>\n" +
"      <li><a href=\"LoanApply.html\">Apply for a loan</a></li>\n" +
 " <li><a href=\"ViewRates1.jsp\">View rates</a></li>\n"+
"      <li><a href=\"LoanTrack.jsp\">Track your  Loan Request</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
            String name=request.getParameter("uname");
            String pass=request.getParameter("pass");
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
            regist1 reg=(regist1)session.createQuery("FROM regist1 r where r.UserName=:username").setParameter("username", name).uniqueResult();
            HttpSession s=request.getSession();
                s.setAttribute("name", reg.getFullName());
                String em=reg.getEmailId();
                s.setAttribute("email",em);
            //out.println(em);
            
            if(reg!=null && reg.getPassword().equals(pass)){
                out.println("<center>");
                
                out.println("<h1>Welcome "+ reg.getFullName()+"</h1><br/><br/>");
                out.println("<a href=\"LoanApply.jsp\" class=\"btn btn-info\" role=\"button\">Apply for a loan</a>"+"<br/><br/>");
                out.println("<a href=\"LoanTrack.jsp\" class=\"btn btn-info\" role=\"button\">Track your loan requests</a>"+"<br/><br/>");
                out.println("<a href=\"custLogin.html\" class=\"btn btn-info\" role=\"button\">Log out</a>"+"<br/><br/>");
                out.println("</center>");
            }
            else{
                out.println("<center><h1>Invalid login!</h1></center>");
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
