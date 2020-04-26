<%-- 
    Document   : edit
    Created on : 24 Apr, 2020, 8:55:19 AM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="package1.HibernateUtil" %>
<%@ page import="package1.loanapplication" %>
<%@ page import="org.hibernate.Transaction" %>

<%
      Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session1.beginTransaction();
           String[] selectedStudentIds = request.getParameterValues("names");
           int id=Integer.parseInt(selectedStudentIds[0]);
           /*Cookie ck=new Cookie("appid",selectedStudentIds[0]);
           response.addCookie(ck);*/
            session.setAttribute("lid", id);
           loanapplication loanapp=(loanapplication)session1.createQuery("FROM loanapplication l where l.AppId=:Appid").setParameter("Appid", id).uniqueResult();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Edit Loan application </title>
        <script>
           function validate(){
               var loanAmt=document.forms["UpdLoanapps"]["loanAmt"].value;
               var custName=document.forms["UpdLoanapps"]["custName"].value;
               var MonthIncome=document.forms["UpdLoanapps"]["MonthIncome"].value;
               var Age=document.forms["UpdLoanapps"]["Age"].value;
               var Addr=document.forms["UpdLoanapps"]["Addr"].value;
               var MobileNo=document.forms["UpdLoanapps"]["MobileNo"].value;
               var AlternateNo=document.forms["UpdLoanapps"]["AlternateNo"].value;
                 var emailId=document.forms["UpdLoanapps"]["emailId"].value;
                 var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
               var numbers = /^[0-9]+$/;
               var re = /^[A-Za-z]+$/;
               var re2 = /^[a-zA-Z]+ [a-zA-Z]+$/
               var phoneno = /^\d{9}$/;
               if(loanAmt==""){
                   alert("Loan Amount is empty! Please fill it!");
                   return false;
               }
               
                  else if(!(loanAmt.match(numbers))){
                       alert("Please enter numbers only for Loan amount!");
                       return false;
                   }
                   else if(custName==""){
                       alert("Customer Name is empty! Please fill it!");
                       return false;
                   }
                  else if(!re2.test(custName)){
                      alert("Invalid name");
                      return false;
                  }
                  else if(MonthIncome==""){
                      alert("Monthly Income is empty!Please fill it!");
                      return false;
                  }
                  else if(!numbers.test(MonthIncome)){
                      alert("Please enter numbers only for Monthly Income!");
                      return false;
                  }
                  else if(Age==""){
                      alert("Age is empty! Please fill it!");
                       return false;
                  }
                  else if(!numbers.test(Age)){
                      alert("Please enter numbers only for Age!");
                      return false;
                  }
                  else if(Addr==""){
                      alert("Address is empty! Please fill it!");
                       return false;
                  }
                  else if(MobileNo==""){
                      alert("Mobile Number is empty! Please fill it!");
                       return false;
                  }
                  else if(!phoneno.test(MobileNo)){
                      alert("Please enter a proper mobile number!");
                      return false;
                  }
                   else if(AlternateNo==""){
                      alert("Alternate Number is empty! Please fill it!");
                       return false;
                  }
                  else if(!phoneno.test(AlternateNo)){
                      alert("Please enter a proper mobile number!");
                      return false;
                  }
                   else if(emailId==""){
                       alert("Email id is empty! Please enter an email id!");
                       return false;
                   }
                   else if(!mailformat.test(emailId)){
                       alert("Email id doesn't match format!");
                       return false;
                   }
               else{
               return true;}
           }
        </script>
    </head>
    <body>
   <center>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid"> 
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bank</a>
    </div>
    <ul class="nav navbar-nav">
     <li ><a href="details">Welcome Admin</a></li>
  <li class="active"><a href="#">Loan Applications</a></li>
       <li><a href="LoanAppDet">Loan Application Details</a></li>
    <li><a href="custInfo">Customer Information</a></li>
      <li><a href="ViewRates.jsp">Rates</a></li>
       <li><a href="RecEMI">Recieved EMIs</a></li>
      <li><a href="calcEMI1">Calculate Emi</a></li>
    </ul>
  </div>
</nav>
           <h1>UPDATE DETAILS</h1>
           <form name="UpdLoanapps" action='upd' onsubmit="return validate();" method="post">
           Loan-Type:
           <br/>
           <select id='typeloan' name='typeloan'>
           <option value='Gold loan'>Gold loan</option>
           <option value='Car loan'>Car loan</option>        
           <option value='Education loan'>Education loan</option>
           <option value='House loan'>House loan</option>
           </select>
           <br/>
           Loan-amount:
           <br/>
           <input type='text' name='loanAmt' value=<% out.println(loanapp.getLoanAmount());%>/>
           <br/>
           customer name:
           <br/>
           <input type='text' name='custName' value=<% out.println(loanapp.getCustName());%>  />
           <br/>
           Monthly Income:
           <br/>
           <input type='text' name='MonthIncome' value=<% out.println(loanapp.getMonthlyIncome());%>/>
           <br/>
           Gender:
           <br/>
           <select id='gender' name='gender'>
           <option value='Male'>Male</option>
           <option value='Female'>Female</option>  
           </select>
           <br/>
           Age:
           <br/>
           <input type='text' name='Age' value=<% out.println(loanapp.getAge());%>/>
           <br/>
           Address:
           <br/>
           <textarea name="Addr" rows="3" cols="50">
               <%out.println(loanapp.getAddress());%>
           </textarea>
           <br/>
           Mobile No:
           <br/>
           <input type='text' name='MobileNo' value=<% out.println(loanapp.getMobileNo());%>/>
           <br/>
           Alternate No:
           <br/>
           <input type='text' name='AlternateNo' value=<% out.println(loanapp.getAlternateNo());%>/>
           <br/>
           Email id:
           <br/>
           <input type='text' name='emailId' value=<% out.println(loanapp.getEmailId());%>/>
           <br/><br/>
           <input type='submit' value='Update'/>&nbsp;&nbsp;
           <input type='submit' value='Go back' formaction="LoanApps"/>
           <br/>
           </form>
           </center>
    </body>
</html>
