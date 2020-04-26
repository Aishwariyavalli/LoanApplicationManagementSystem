<%-- 
    Document   : edit2
    Created on : 24 Apr, 2020, 11:58:26 AM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="package1.HibernateUtil" %>
<%@ page import="package1.LoanMaster1" %>
<%@ page import="package1.CustMaster" %>
<%@ page import="org.hibernate.Transaction" %>

<%
     Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session1.beginTransaction();
           String[] selectedStudentIds = request.getParameterValues("names");
           int id=Integer.parseInt(selectedStudentIds[0]);
         /* Cookie ck=new Cookie("loanid",selectedStudentIds[0]);
           response.addCookie(ck);*/
          session.setAttribute("lid", id);
           CustMaster cust=(CustMaster)session1.createQuery("FROM CustMaster c where c.CID=:CID").setParameter("CID", id).uniqueResult();
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Edit Customer Info </title>
       
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid"> 
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bank</a>
    </div>
    <ul class="nav navbar-nav">
     <li ><a href="details">Welcome Admin</a></li>
  <li ><a href="LoanApps">Loan Applications</a></li>
       <li><a href="LoanAppDet">Loan Application Details</a></li>
    <li class="active"><a href="#">Customer Information</a></li>
      <li><a href="ViewRates.jsp">Rates</a></li>
       <li><a href="RecEMI">Recieved EMIs</a></li>
      <li><a href="calcEMI1">Calculate Emi</a></li>
    </ul>
  </div>
</nav>
         <script>
            function validate1(){
                var custName=document.forms["updCust"]["custName"].value;
               var PANNo=document.forms["updCust"]["PANNo"].value;
               var city=document.forms["updCust"]["city"].value;
               var addr=document.forms["updCust"]["addr"].value;
               var MNo=document.forms["updCust"]["MNo"].value;
               var ANo=document.forms["updCust"]["ANo"].value;
                 var DOB=document.forms["updCust"]["DOB"].value;
                
               var re = /^[A-Za-z]+$/;
               var phoneno = /^\d{9}$/;
               var PAN = /([A-Z]){5}([0-9]){4}([A-Z]){1}$/;
               var re2 = /^[a-zA-Z]+ [a-zA-Z]+$/
               var re1 = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
               if(custName==""){
                       alert("Customer Name is empty! Please fill it!");
                       return false;
                   }
                  else if(!re2.test(custName)){
                      alert("Invalid Customer name");
                      return false;
                  }
                  else if(PANNo==""){
                      alert("PAN number is empty!Please fill it!");
                      return false;
                  }
                  else if(!PAN.test(PANNo)){
                      alert("Invalid PAN Number!");
                      return false;
                  }
                  
                 if(city==""){
                       alert("city is empty! Please fill it!");
                       return false;
                   }
                  else if(!re.test(city)){
                      alert("Invalid city!");
                      return false;
                  }
                  else if(addr==""){
                      alert("Address is empty! Please fill it!");
                       return false;
                  }
                  else if(MNo==""){
                      alert("Mobile Number is empty! Please fill it!");
                       return false;
                  }
                  else if(!phoneno.test(MNo)){
                      alert("Please enter a proper mobile number!");
                      return false;
                  }
                   else if(ANo==""){
                      alert("Alternate Number is empty! Please fill it!");
                       return false;
                  }
                  else if(!phoneno.test(ANo)){
                      alert("Please enter a proper mobile number!");
                      return false;
                  }
                   /*else if(DOB==""){
                       alert("DOB is empty! Please enter an email id!");
                       return false;
                   }
                   else if(!re1.test(DOB)){
                       alert("Date doesn't match format!");
                       return false;
                   }*/
               else{
               return true;}
           }
        </script>
        <center>
          <h1>UPDATE DETAILS</h1>
          <form action='upd2' method='post' name='updCust' onsubmit="return validate1();">
           <br/>
          Customer Name:
          <br/>
          <input type='text' name='custName' value='<%out.println(cust.getCustName());%>'/>
          <br/>
          PAN No:
          <br/>
          <input type='text' name='PANNo' value='<%out.println(cust.getPANNo());%>'/>
          <br/>
          Gender:
          <br/>
          <select id='gender' name='gender'>
          <option value='Male'>Male</option>
          <option value='Female'>Female</option>  
          </select>
          <br/>
          City:
          <br/>
          <input type='text' name='city' value='<%out.println(cust.getCity());%>'/>
          <br/>
          Address:
          <br/>
          <textarea rows="3" cols="40" name="addr">
              <%out.println(cust.getAddress());%>
          </textarea>
          <br/>
          Mobile No:
          <br/>
          <input type='text' name='MNo' value='<%out.println(cust.getMobileNo());%>'/>
          <br/>
          Alternate No:
          <br/>
          <input type='text' name='ANo' value='<%out.println(cust.getAlternateNo());%>'/>
          <br/>
          Date Of birth
          <br/>
          <input type='date' name='DOB' value='<%out.println(cust.getDob());%>' required/>
          <br/>
          Status:
          <br/>
          <select id='status' name='status'>
          <option value='active'>active</option>
          <option value='Inactive'>Inactive</option>  
          </select>
          <br/><br/>
          <input type='submit' value='Update'/>
          <br/>
          </form>
          </center>
    </body>
</html>
