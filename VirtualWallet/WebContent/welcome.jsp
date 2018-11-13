<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Account"%>
<%@page import="model.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
 <h3>Hello! Welcome to Infiniti Space Bank!</h3>
 
<form method="POST" action="Bank">
Input user name, we will create a virtual wallet for you!<br><br>
 User name:  <input type="text" name="username"/><br><br>
 <input type="hidden" name="ActionType" value = "createWallet"/> 
 <input type="submit" value="Create Virtual Wallet"/><br><br>
 </form>
 
 Already have a wallet? Input user name to login!<br>
 <div>
<%
	String error= (String)request.getAttribute("accountError");
    if(error!=null&&error.length()!=0){
%>
<p style="color:red"><%=error%></p>
<%
    }
%>
</div>
<form method="POST" action="Bank">
 User name:  <input type="text" name="loginname"/><br><br>
 <input type="hidden" name="ActionType" value = "login"/> 
 <input type="submit" value="Login"/>
</form>
</body>
</html>