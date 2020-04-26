<%-- 
    Document   : LoanApply
    Created on : 24 Apr, 2020, 10:11:24 PM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    
    String name=(String)session.getAttribute("name");
    String emailid=(String)session.getAttribute("email");
%>
<html>
    <head>
        <title> Apply for a loan </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
      function validate(){
          var DOB=document.forms["loanapply"]["DOB"].value;
          var age=document.forms["loanapply"]["age"].value;
          var PANNo=document.forms["loanapply"]["PANNo"].value;
          var city=document.forms["loanapply"]["city"].value;
          var Addr=document.forms["loanapply"]["Addr"].value;
          var MobileNo=document.forms["loanapply"]["MobileNo"].value;
          var AlternateNo=document.forms["loanapply"]["AlternateNo"].value;
          var loanTenure=document.forms["loanapply"]["loanTenure"].value;
          var InterestR=document.forms["loanapply"]["InterestR"].value;
          var LoanAmt=document.forms["loanapply"]["LoanAmt"].value;
          var MonthIncome=document.forms["loanapply"]["MonthIncome"].value;
          var MortgageDetails=document.forms["loanapply"]["MortgageDetails"].value;
          var GName=document.forms["loanapply"]["GName"].value;
          var Addr1=document.forms["loanapply"]["Addr1"].value;
          var CNo=document.forms["loanapply"]["CNo"].value;
          var PAN = /([A-Z]){5}([0-9]){4}([A-Z]){1}$/;
           var re = /^[A-Za-z]+$/;
           var re2 = /^[a-zA-Z]+ [a-zA-Z]+$/
            var phoneno = /^\d{9}$/;
          if(DOB==""){
              alert("Enter Date Of Birth!");
              return false;
          }
          else if(age==""){
              alert("Enter age!");
              return false;
          }
          else if(PANNo==""){
              alert("Enter PAN number!");
              return false;
          }
          else if(!PAN.test(PANNo)){
              alert("Please enter a proper PAN number!");
              return false;
          }
          else if(city==""){
              alert("Please enter city");
              return false;
          }
          else if(!re.test(city)){
              alert("Please enter proper city! No numbers please!");
              return false;
          }
          else if(Addr==""){
              alert("Please enter address!");
              return false;
          }
          else if(MobileNo==""){
              alert("Please enter MobileNO!");
              return false;
          }
          else if(!phoneno.test(MobileNo)){
              alert("Please enter a proper mobile no!");
              return false;
          }
          else if(AlternateNo==""){
              alert("Please enter MobileNO!");
              return false;
          }
          else if(!phoneno.test(AlternateNo)){
              alert("Please enter a proper mobile no!");
              return false;
          }
          else if(loanTenure==""){
              alert("Please enter loan Tenure!");
              return false;
          }
          else if(InterestR==""){
              alert("Please enter interest rate!");
              return false;
          }
          else if(LoanAmt==""){
              alert("please enter loan amount!");
              return false;
          }
          else if(MonthIncome==""){
              alert("Please enter Month Income!");
              return false;
          }
          else if(MortgageDetails==""){
              alert("Please enter Mortgage Details!");
              return false;
          }
          else if(!re2.test(MortgageDetails)){
              alert("Please enter proper Mortgage details!");
              return false;
          } 
          else if(GName==""){
              alert("Please enter Guarantor Name!");
              return false;
          }
          else if(!re2.test(GName)){
              alert("Invalid Guarantor Name!");
              return false;
          }
          else if(Addr1==""){
              alert("Please enter Guarantor Address!");
              return false;
          }
          else if(CNo==""){
              alert("Please enter Guarantor phone number!");
              return false;
          }
          else{
              return true;
          }
              
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
      <li ><a href="index.html">Home</a></li>
       <li><a href="regUser.html">Register user</a></li>
      <li><a href="custLogin.html">Customer Login</a></li>
      <li  class="active"><a href="LoanApply.jsp">Apply for a loan</a></li>
      <li><a href="LoanTrack.jsp">Track Loan Request</a></li>
       <li><a href="ViewRates1.jsp">View rates</a></li>
    </ul>
  </div>
</nav>
    <center>
      <form action="addLoan" name="loanapply" onsubmit="return validate();" method="post">
          Customer name: <input type="text" name="CName" value="<% out.println(name);%>" readonly/>
          <br/><br/>
          Date Of Birth: <input type="date" name="DOB"/>
          <br/><br/>
          Age: <input type="number" name="age"/>
          <br/><br/>
           Gender: <select id='gender' name='gender'>
           <option value='Male'>Male</option>
           <option value='Female'>Female</option>  
           </select>
           <br/><br/>
           Email id: <input type="text" name="emailid" value="<%out.println(emailid);%>" readonly />
           <br/><br/>
           PAN number: <input type="text" name="PANNo"/>
          <br/><br/>
           City: <input type="text" name="city"/>
           <br/><br/>
           Address: <textarea name="Addr" rows="3" cols="50"></textarea>
              
           
           <br/><br/>
           Mobile No: <input type="text" name="MobileNo"/>
           <br/><br/>
           Alternate No: <input type="text" name="AlternateNo"/>
           <br/><br/>
           Loan Type: <select id='typeloan' name='typeloan'>
           <option value='Gold loan'>Gold loan</option>
           <option value='Car loan'>Car loan</option>        
           <option value='Education loan'>Education loan</option>
           <option value='House loan'>House loan</option>
           </select>
           <br/><br/>
           Loan Tenure(in months): <input type="number" name="loanTenure"/>
           <br/><br/>
           Interest Type: <select id='InterestType' name='InterestType'>
           <option value='Fixed'>Fixed</option>
           <option value='Floating'>Floating</option>  
           </select>
           <br/><br/>
           Interest Rate: <input type="number" name="InterestR"/>
           <br/><br/>
           Loan Amount: <input type="number" name="LoanAmt"/>
           <br/><br/>
           Monthly Income: <input type="number" name="MonthIncome"/>
           <br/><br/>
           Mortgage Details: <input type="text" name="MortgageDetails"/>
           <br/><br/>
           <h1>Guarantor Details</h1>
           Name: <input type="text" name="GName"/>
           <br/><br/>
           Address: <textarea name="Addr1" rows="3" cols="50"></textarea>
              
           
           <br/><br/>
           Contact No: <input type="text" name="CNo"/>
           <br/><br/>
           <input type="submit" value="submit"/>
           
      </form>
    </center>
    </body>
</html>
