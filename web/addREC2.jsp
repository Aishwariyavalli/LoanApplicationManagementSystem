<%-- 
    Document   : addfix
    Created on : 23 Apr, 2020, 9:24:49 PM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="package1.HibernateUtil" %>
<%@ page import="package1.EMI2" %>
<%@ page import="org.hibernate.Transaction" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Add recieved EMI</title>
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
          String cid=request.getParameter("cid");
          int cid1=Integer.parseInt(cid);
          Session session1 = HibernateUtil.getSessionFactory().openSession();
             
            Transaction tx=session1.beginTransaction();
           EMI2 emi=(EMI2)session1.createQuery("FROM EMI2 e where e.CID=:CID").setParameter("CID", cid1).uniqueResult();
           if(emi==null){
               response.sendRedirect("error.html");
               if(true) return;
           }
           
   %>
    <center>
        <form action="addREC3" name="addREC" onsubmit="return validate();" method="post">
            Customer id: <br/>
            <input type="text" name="cid" value=<% out.println(cid1);%>/>
            <br/>
            No.of.Payments: <br/>
            <input type="text" name="NoofP"/>
            <br/>
            Reciept Date: <br/>
            <input type="date" name="RDate" required/>
            <br/>
            EMI Date: <br/>
            <input type="date" name="EDate" required/>
            <br/>
            EMI amount:<br/>
            <input type="text" name="EMIAmt" value=<% out.println(emi.getEMIAmount());%>>
            <br/>
            Late fine Charge: <br/>
           <input type="text" name="LFC" />
           <br/><br/>
           <input type="submit" value="Add"/>
        </form>
    </center>
    </body>
</html>
