<%-- 
    Document   : edit1.jsp
    Created on : 24 Apr, 2020, 11:13:24 AM
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
          /*Cookie ck=new Cookie("loanid",selectedStudentIds[0]);
           response.addCookie(ck);*/
           session.setAttribute("lid", id);
           LoanMaster1 loanapp=(LoanMaster1)session1.createQuery("FROM LoanMaster1 l where l.LoanId=:LoanId").setParameter("LoanId", id).uniqueResult();
           CustMaster cust=(CustMaster)session1.createQuery("FROM CustMaster CM where CM.CID=:CID").setParameter("CID", id).uniqueResult(); 
%>
<!DOCTYPE html>
<html>
    <head>
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Edit Loan application details </title>
        <script>
            function validate(){
               var loanAmt=document.forms["loanappdet"]["loanAmt"].value;
              
               var loanTenure=document.forms["loanappdet"]["loanTenure"].value;
               var InterestRate=document.forms["loanappdet"]["InterestRate"].value;
               var Addr=document.forms["loanappdet"]["Addr"].value;
               var IssueDate=document.forms["loanappdet"]["IssueDate"].value;
                 var MortDet=document.forms["loanappdet"]["MortDet"].value;
                  var GuarantorNm=document.forms["loanappdet"]["GuarantorNm"].value;
                  var ContactNo=document.forms["loanappdet"]["ContactNo"].value;
                 
               var numbers = /^[0-9]+$/;
               var re = /^[A-Za-z]+$/;
               var re2 = /^[a-zA-Z]+ [a-zA-Z]+$/
               var re1 = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
               var phoneno = /^\d{9}$/;
               if(loanAmt==""){
                   alert("Loan Amount is empty! Please fill it!");
                   return false;
               }
               
                  else if(!numbers.test(loanAmt)){
                       alert("Please enter numbers only for Loan amount!");
                       return false;
                   }
                   else if(loanTenure==""){
                       alert("Loan Tenure is empty! Please fill it!");
                       return false;
                   }
                  else if(!numbers.test(loanTenure)){
                      alert("Please enter only numbers for loan Tenure!");
                      return false;
                  }
                  else if(InterestRate==""){
                      alert("Interest Rate is empty!Please fill it!");
                      return false;
                  }
                  else if(!numbers.test(InterestRate)){
                      alert("Please enter numbers only for Interest Rate!");
                      return false;
                  }
                 
                  else if(Addr==""){
                      alert("Address is empty! Please fill it!");
                       return false;
                  }
                  /*else if(IssueDate==""){
                      alert("Mobile Number is empty! Please fill it!");
                       return false;
                  }
                  else if(!re1.test(IssueDate)){
                      alert("Please enter a proper date format!");
                      return false;
                  }*/
                  else if(MortDet==""){
                       alert("Mortgage details is empty! Please fill it!");
                       return false;
                   }
                  else if(!re2.test(MortDet)){
                      alert("Invalid Mortgage details!");
                      return false;
                  }
                  else if(GuarantorNm==""){
                       alert("Guarantor Name is empty! Please fill it!");
                       return false;
                   }
                  else if(!re2.test(GuarantorNm)){
                      alert("Invalid Guarantor name!");
                      return false;
                  }
                   else if(ContactNo==""){
                      alert("Alternate Number is empty! Please fill it!");
                       return false;
                  }
                  else if(!phoneno.test(ContactNo)){
                      alert("Please enter a proper mobile number!");
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
  <li ><a href="LoanApps">Loan Applications</a></li>
       <li class="active"><a href="#">Loan Application Details</a></li>
    <li><a href="custInfo">Customer Information</a></li>
      <li><a href="ViewRates.jsp">Rates</a></li>
       <li><a href="RecEMI">Recieved EMIs</a></li>
      <li><a href="calcEMI1">Calculate Emi</a></li>
    </ul>
  </div>
</nav>
         <center>
           <h1>UPDATE DETAILS</h1>
           <form action='upd1' name="loanappdet" onsubmit="return validate();">
            <br/>
           Customer Name:
           <br/>
           <input type='text' name='custName' value=<%out.println(cust.getCustName());%> readonly/>
           <br/>
           Loan-Type:
           <br/>
           <select id='typeloan' name='typeloan'>
           <option value='Gold loan'>Gold loan</option>
           <option value='Car loan'>Car loan</option>        
           <option value='Education loan'>Education loan</option>
           <option value='House loan'>House loan</option>
           </select>
           <br/>
           Loan-Tenure:
           <br/>
           <input type='text' name='loanTenure' value=<%out.println(loanapp.getLoanTenure());%>/>
           <br/>
           Loan-amount:
           <br/>
           <input type='text' name='loanAmt' value=<%out.println(loanapp.getLoanAmount());%>/>
           <br/>
           Interest Type:
           <br/>
           <select id='InterestType' name='InterestType'>
           <option value='Fixed'>Fixed</option>
           <option value='Floating'>Floating</option>  
           </select>
           <br/>
           Interest Rate:
           <br/>
           <input type='text' name='InterestRate' value=<%out.println(loanapp.getInterestRate());%>/>
           <br/>
           <br/>
           Issue Date(dd/mm/yyyy):
           <br/>
           <input type='date' name='IssueDate' value=<%out.println(loanapp.getIssueDate());%> required/>
           <br/>
           Mortgage Details:
           <br/>
           <input type='text' name='MortDet' value="<%out.println(loanapp.getMortgageDetails());%>"/>
           <br/>
           <h2>Guarantor Details:</h2>
           Guarantor Name:
           <br/>
           <input type='text' name='GuarantorNm' value="<%out.println(loanapp.getGuarantorName());%>"/>
           <br/>
           Address:
           <br/>
           <textarea name="Addr" rows="3" cols="50">
               <%out.println(loanapp.getAddress());%>
           </textarea>
           <br/>
           Contact No:
           <br/>
           <input type='text' name='ContactNo' value=<%out.println(loanapp.getContactNo());%>/>
           <br/><br/>
           <input type='submit' value='Update'/>&nbsp;&nbsp;
           
           <input type='submit' value='Go back' formaction="LoanAppDet"/>
           <br/>
           </form>
           </center>
    </body>
</html>
