package package1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(urlPatterns = {"/addLoan"})
public class addLoan extends HttpServlet {

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
           String CName=request.getParameter("CName");
           String DOB=request.getParameter("DOB");
           int age=Integer.parseInt(request.getParameter("age"));
           String gender=request.getParameter("gender");
           String emailid=request.getParameter("emailid");
           String PANNo=request.getParameter("PANNo");
           String city=request.getParameter("city");
           String Addr=request.getParameter("Addr");
           int MobileNo=Integer.parseInt(request.getParameter("MobileNo"));
           int AlternateNo=Integer.parseInt(request.getParameter("AlternateNo"));
           String typeloan=request.getParameter("typeloan");
           int loanTenure=Integer.parseInt(request.getParameter("loanTenure"));
           String InterestType=request.getParameter("InterestType");
           Integer InterestR=Integer.parseInt(request.getParameter("InterestR"));
           int LoanAmt=Integer.parseInt(request.getParameter("LoanAmt"));
           int MonthIncome=Integer.parseInt(request.getParameter("MonthIncome"));
           String MortgageDetails=request.getParameter("MortgageDetails");
           String GName=request.getParameter("GName");
           String Addr1=request.getParameter("Addr1");
           int CNo=Integer.parseInt(request.getParameter("CNo"));
          CustMaster c=new CustMaster();
          c.setCustName(CName);
          c.setPANNo(PANNo);
          c.setGender(gender);
          c.setCity(city);
          c.setAddress(Addr);
          c.setMobileNo(MobileNo);
          c.setAlternateNo(AlternateNo);
          c.setDob(DOB);
          c.setStatus("Active");
          session.save(c);
          
          int id=c.getCID();
          LoanMaster1 l=new LoanMaster1();
          l.setCID(id);
          l.setLoanType(typeloan);
          l.setLoanTenure(loanTenure);
          l.setLoanAmount(LoanAmt);
          l.setInterestType(InterestType);
          LocalDateTime now = LocalDateTime.now();  
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
           String strDate = dtf.format(now);
           l.setIssueDate(strDate);
           l.setMortgageDetails(MortgageDetails);
           l.setGuarantorName(GName);
           l.setAddress(Addr1);
           l.setContactNo(CNo);
           l.setInterestRate(InterestR);
           l.setApprStatus(0);
           session.save(l);
           
           loanapplication la=new loanapplication();
           la.setLoanType(typeloan);
           la.setLoanAmount(LoanAmt);
           la.setCustName(CName);
           la.setMonthlyIncome(MonthIncome);
           la.setGender(gender);
           la.setAge(age);
           la.setAddress(Addr);
           la.setMobileNo(MobileNo);
           la.setAlternateNo(AlternateNo);
           la.setEmailId(emailid);
           session.save(la);
           tx.commit();
           response.sendRedirect("success1.html");
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
