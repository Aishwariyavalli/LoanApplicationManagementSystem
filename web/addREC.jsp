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
        <title>Add Recieved  EMI</title>
       
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
    <center>
        <form action="addREC2.jsp" name="addREC" method="post" onsubmit="return validate();">
            Customer id: <br/>
            <input type="number" name="cid" required/>
            <br/><br/> 
            <input type="submit" value="Search EMI" name="Search EMI"/>
            
        </form>
    </center>
    </body>
</html>
