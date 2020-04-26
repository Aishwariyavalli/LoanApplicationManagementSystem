<%-- 
    Document   : ViewRates
    Created on : 23 Apr, 2020, 10:04:04 PM
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
        <title>View Rates</title>
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
                <form action="fixedRates" method="post">
                    <input type='submit' value='View fixed rates'/>
                    <input type='submit' value='View floating rates' formaction='floatingRates'/>
                    
                </form>
            </center>
</nav>
    </body>
</html>
