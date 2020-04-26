<%-- 
    Document   : editF
    Created on : 23 Apr, 2020, 9:50:53 PM
    Author     : Aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="package1.HibernateUtil" %>
<%@ page import="package1.Fixed" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
        <title>Edit fixed rate</title>
         <script>
            function validate1(){
                var duration=document.forms["efix"]["duration"].value;
               var Rate=document.forms["efix"]["Rate"].value;
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
   <% 
          /*Fixed f=(Fixed)session.getAttribute("fixed");
          Cookie [] cookies=request.getCookies();
          String id=cookies[0].getValue();
          session.setAttribute("id", id);*/
          Session session1 = HibernateUtil.getSessionFactory().openSession();
             //HttpSession s=request.getSession();
            Transaction tx=session1.beginTransaction();
            String[] selectedStudentIds = request.getParameterValues("names");
           int id=Integer.parseInt(selectedStudentIds[0]);
           /*Cookie ck=new Cookie("floatingid",selectedStudentIds[0]);
            response.addCookie(ck);  */
           session.setAttribute("fix", id);
            Fixed f=(Fixed)session1.createQuery("FROM Fixed f where f.No=:No").setParameter("No", id).uniqueResult();
        //Floating f=(Floating)session.getAttribute("fixed");
          
    %>
     <center>
        <form action="editfix1" name="efix" onsubmit="return validate1();">
             Loan-Type:<br/>
            <select id="typeloan" name="typeloan">
                <option value="Gold Loan">Gold Loan</option>
                <option value="Car Loan">Car Loan</option>
                <option value="Education Loan">Education Loan</option>
                <option value="House Loan">House Loan</option>
            </select>
            <br/>
            Duration(nn-nn years): <br/>
            <input type="text" name="duration" value='<% out.println(f.getDuration()); %>'/>
            <br/>
             Interest Rate: <br/>
            <input type="text" name="Rate" value='<% out.println(f.getRate()); %>'/>
            <br/><br/>
             <input type='submit' value='Update'/>
        </form>
    </center>
    </body>
</html>
