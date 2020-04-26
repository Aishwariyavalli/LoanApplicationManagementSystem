<%-- 
    Document   : ViewRates1
    Created on : 25 Apr, 2020, 7:28:10 PM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List, java.util.Iterator" %>
<%@ page import="package1.HibernateUtil" %>
<%@ page import="package1.Fixed" %>
<%@ page import="package1.Floating" %>
<%@ page import="org.hibernate.Transaction" %>

   <% 
          
          Session session1 = HibernateUtil.getSessionFactory().openSession();
             
            Transaction tx=session1.beginTransaction();
           List l=session1.createQuery("From Fixed").list();
           List l1=session1.createQuery("From Floating").list();
           
           
   %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>View Rates</title>
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
       <li class="active"><a href="ViewRates1.jsp">View rates</a></li>
      <li><a href="LoanTrack.jsp">Track Loan Request</a></li>
    </ul>
  </div>
</nav>
    <center>
        <h1> Fixed Rates:</h1><br/><br/>
        <table class='table table-hover'>
            <tr>
                <th>Loan Type</th>
                <th>Duration</th>
                <th>Rate</th>
            </tr>
    
        <%
            for(Iterator iterator=l.iterator();iterator.hasNext();)
            {
                Fixed f=(Fixed)iterator.next();
                out.println("<tr>");
                out.println("<td>"+f.getLoanType()+"</td>");
                out.println("<td>"+f.getDuration()+"</td>");
                out.println("<td>"+f.getRate()+"</td>");
                out.println("</tr>");
            }
        %>
    </table>
        <br/><br/>
        <h1> Floating Rates:</h1><br/><br/>
        <table class='table table-hover'>
            <tr>
                <th>Loan Type</th>
                <th>Duration</th>
                <th>Rate</th>
            </tr>
    
        <%
            for(Iterator iterator=l1.iterator();iterator.hasNext();)
            {
                Floating f=(Floating)iterator.next();
                out.println("<tr>");
                out.println("<td>"+f.getLoanType()+"</td>");
                out.println("<td>"+f.getDuration()+"</td>");
                out.println("<td>"+f.getRate()+"</td>");
                out.println("</tr>");
            }
        %>
    </table>
    </center>
    </body>
</html>
