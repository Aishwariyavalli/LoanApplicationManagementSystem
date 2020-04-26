<%-- 
    Document   : LoanTrack
    Created on : 25 Apr, 2020, 12:25:35 AM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List, java.util.Iterator" %>
<%@ page import="package1.HibernateUtil" %>
<%@page import="org.hibernate.Query"%>
<%@ page import="package1.loanapplication" %>
<%@ page import="package1.LoanMaster1" %>
<%@ page import="package1.CustMaster" %>
<%@ page import="org.hibernate.Transaction" %>
<%
      Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session1.beginTransaction();
           String name=(String)session.getAttribute("name");
           //List loanapps=session1.createQuery("FROM loanapplication l where l.CustName=:CustName").setParameter("CustName", name).list();
           
           CustMaster cust=(CustMaster)session1.createQuery("FROM CustMaster c where c.CustName=:CustName").setParameter("CustName", name).uniqueResult();
           //out.println(cust.getCID());
           if(cust==null){
               response.sendRedirect("Error2.html");
               if(true) return;
           }
           List lms=session1.createQuery("FROM LoanMaster1 l where l.CID=:CID").setParameter("CID", cust.getCID()).list();
           //out.println(lms);
          
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Track your loan request</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="index.html">Home</a></li>
       <li><a href="regUser.html">Register user</a></li>
      <li><a href="custLogin.html">Customer Login</a></li>
      <li><a href="LoanApply.jsp">Apply for a loan</a></li>
       <li><a href="ViewRates1.jsp">View Rates</a></li>
      <li class="active"><a href="LoanTrack.jsp">Track Loan Request</a></li>
    </ul>
  </div>
</nav>
    <center>
        <div class="container">
            <table class='table table-hover'>
                <tr>
                    <th>Loan Type</th>
                     <th>Loan Amount</th>
                       <th>Loan Tenure</th>
                      <th>Interest Type</th>
                      <th>Interest Rate</th>
                      <th>Guarantor Name</th>
                      <th>Guarantor address</th>
                      <th>Guarantor contact number</th>
                      <th>Approval status</th>
                </tr>
                <%
                     
                      for (Iterator iterator = lms.iterator(); iterator.hasNext();){
                          LoanMaster1 l=(LoanMaster1)iterator.next();
                          out.println("<td>"+l.getLoanType()+"</td>");
                          out.println("<td>"+l.getLoanAmount()+"</td>");
                          out.println("<td>"+l.getLoanTenure()+"</td>");
                          out.println("<td>"+l.getInterestType()+"</td>");
                          out.println("<td>"+l.getInterestRate()+"</td>");
                          out.println("<td>"+l.getGuarantorName()+"</td>");
                          out.println("<td>"+l.getAddress()+"</td>");
                          out.println("<td>"+l.getContactNo()+"</td>");
                          int stat=l.getApprStatus();
                          if(stat==0){
                              out.println("<td>"+"Pending"+"</td>");
                          }
                          else if(stat==1){
                              out.println("<td>"+"Approved"+"</td>");
                          }
                          else{
                              out.println("<td>"+"Rejected"+"</td>");
                          }
                      }
                      out.println("</tr>");
                    %>
            </table>
        </div>
    </center>
    </body>
</html>
