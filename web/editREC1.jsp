<%-- 
    Document   : editREC1
    Created on : 24 Apr, 2020, 12:13:38 AM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="package1.RecieveEmi" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="package1.HibernateUtil" %>
<%@ page import="org.hibernate.Transaction" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Edit Recieved EMI</title>
         <script>
            function validate(){
               var NoofP=document.forms["addREC"]["NoofP"].value;
               var RDate=document.forms["addREC"]["RDate"].value;
               var LFC=document.forms["addREC"]["LFC"].value;
               var EDate=document.forms["addREC"]["EDate"].value;
                 var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                  var r=/^(\d*\.)?\d+$/;
               var numbers = /^[0-9]+$/;
               var re = /^[A-Za-z]+$/;
                var re1 = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
               var phoneno = /^\d{9}$/;
               if(NoofP==""){
                   alert("No.of.payments is empty! Please fill it!");
                   return false;
               }
               
                  else if(!(NoofP.match(numbers))){
                       alert("Please enter numbers only for No.of.payments!");
                       return false;
                   }
                 /*else if(RDate==""){
                     alert("Reciept Date is empty! Please fill it");
                     return false;
                 }
                 else if(!re1.test(RDate)){
                     alert("Date doesnt match format!");
                     return false;
                 }
                 else if(EDate==""){
                     alert("EMI Date is empty! Please fill it");
                     return false;
                 }
                 else if(!re1.test(EDate)){
                     alert("Date doesnt match format!");
                     return false;
                 }*/
                 else if(LFC==""){
                   alert("Late Fine Charge is empty! Please fill it!");
                   return false;
               }
               
                  else if(!(LFC.match(r))){
                       alert("Please enter numbers only for Late Fine Charge!");
                       return false;
                   }
               else{
               return true;}
           }
        </script>
    </head>
    <body>
       <nav class="navbar navbar-inverse">
  <div class="container-fluid"> 
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bank</a>
    </div>
    <ul class="nav navbar-nav">
     <li ><a href="details">Welcome Admin</a></li>
  <li><a href="LoanApps">Loan Applications</a></li>
       <li><a href="LoanAppDet">Loan Application Details</a></li>
    <li><a href="custInfo">Customer Information</a></li>
      <li><a href="ViewRates.jsp">Rates</a></li>
       <li class="active"><a href="#">Recieved EMIs</a></li>
      <li><a href="calcEMI1">Calculate Emi</a></li>
    </ul>
  </div>
</nav>
       <%
           //RecieveEmi R=(RecieveEmi)session.getAttribute("fixed");
           Session session1 = HibernateUtil.getSessionFactory().openSession();
             HttpSession s=request.getSession();
            Transaction tx=session1.beginTransaction();
            String[] selectedStudentIds = request.getParameterValues("names");
           int id=Integer.parseInt(selectedStudentIds[0]);
           session.setAttribute("lid", id);
           RecieveEmi R=(RecieveEmi)session1.createQuery("FROM RecieveEmi R where R.RecieptNo=:No").setParameter("No", id).uniqueResult();
           %>
    <center>
        <form action="editREC2" name="addREC" onsubmit="return validate();" method="post">
            Customer id: <br/>
            <input type="text" name="cid" value=<% out.println(R.getCID());%> readonly/>
            <br/>
            No.of.Payments: <br/>
            <input type="text" name="NoofP"  value=<% out.println(R.getNoOfPayment()); %>/>
            <br/>
            Reciept Date: <br/>
            <input type="date" name="RDate" value=<% out.println(R.getRecieptDate()); %> required/>
            <br/>
            EMI Date: <br/>
            <input type="date" name="EDate" value=<% out.println(R.getEMIDate()); %> required/>
            <br/>
            EMI amount:<br/>
            <input type="text" name="EMIAmt" value=<% out.println(R.getEMIAmount());%> readonly>
            <br/>
            Late fine Charge: <br/>
           <input type="text" name="LFC" value=<% out.println(R.getLateFineCharge()); %>/>
           <br/>
           <br/><br/>
           <input type="submit" value="Update"/>
        </form>
    </center>
    </body>
</html>

