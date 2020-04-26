<%-- 
    Document   : addfix
    Created on : 23 Apr, 2020, 9:24:49 PM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
        <title>Add fixed Rate</title>
        <script>
            function validate1(){
                var duration=document.forms["addfix"]["duration"].value;
               var Rate=document.forms["addfix"]["Rate"].value;
               var dur=/^\d{1,2}-\d{1,2} (years)/;
               var r=/^(\d*\.)?\d+$/;
               if(duration==""){
                   alert("Enter a duration!");
                   return false;
               }
               else if(!dur.test(duration)){
                   alert("Enter correct format for duration!");
                   return false;
               }
                else if(Rate==""){
                    alert("Rate is empty!Enter a rate!");
                    return false;
                }
               else if(!r.test(Rate)){
                   alert("Enter numbers only for rate!");
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
     <li ><a href="details">Welcome Admin</a></li>
  <li><a href="LoanApps">Loan Applications</a></li>
       <li><a href="LoanAppDet">Loan Application Details</a></li>
    <li><a href="custInfo">Customer Information</a></li>
      <li class="active"><a href="#">Rates</a></li>
    <li><a href="RecEMI">Recieved EMis</a></li>
      <li><a href="calcEMI1">Calculate Emi</a></li>
    </ul>
  </div>
</nav>
    <center>
        <form action="addfix1" name="addfix" method="post" onsubmit="return validate1();">
            Loan-Type:<br/>
            <select id="typeloan" name="typeloan">
                <option value="Gold Loan">Gold Loan</option>
                <option value="Car Loan">Car Loan</option>
                <option value="Education Loan">Education Loan</option>
                <option value="House Loan">House Loan</option>
            </select>
            <br/>
            Duration(nn-nn years): <br/>
            <input type="text" name="duration"/>
            <br/>
            Interest Rate: <br/>
            <input type="text" name="Rate"/>
            <br/><br/>
            <input type='submit' value='Add'/>
        </form>
    </center>
    </body>
</html>
