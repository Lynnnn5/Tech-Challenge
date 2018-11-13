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
 
<div style="float:left;width=200px">
<h3>Here are your accounts: </h3>
<%
	 List<Account> accounts= (List<Account>)request.getAttribute("accounts");
    if (accounts != null) {
	for (Account a:accounts) {
%>
   <br>
   Account Name: <%=a.getAccountName()%><br>
   Account ID: <%=a.getAccountId()%><br>
   Balance: <%=a.getBalence()%><br>
<form method="POST" action="Bank">
<input type="hidden" name="ActionType" value = "history"/> 
<input type="hidden" name="accNum" value = "<%=a.getAccountId()%>"/> <br>
<input type="submit" value="Check Transaction History"/>
</form>
   -----------------------<br>
<%
	}
}	
%>
<div style="white-space: pre-line;">
<h3>Transaction History</h3>
<%
	List<Transaction> trans= (List<Transaction>)request.getAttribute("transactions");
    if (trans != null) {
	for (Transaction t:trans) {
%>
   <%=t.toString()%>
   <%
	}
}	
%>
</div>
</div>


<div style="width:700px;float:right">
<div>
<%
	String error= (String)request.getAttribute("error");
    if(error!=null&&error.length()!=0){
%>
<p style="color:red"><%=error%></p>
<%
    }
%>
</div>
<div>
<h3>Deposit or Withdraw</h3>

<form method="POST" action="Bank">
Account Number:<br>
 <input type="text" name="accountNum"/><br>
Amount:<br>
 <input type="text" name="amount"/><br>
 <input type="submit" name="ActionType" value="Deposit"/>
 <input type="submit" name="ActionType" value="Withdraw"/>
</form>
</div>

<div>
<h3>Transfer</h3>
<form method="POST" action="Bank">
 Transfer from (input account number):<br>
 <input type="text" name="accountFrom"/><br>
 Transfer to (input account number): <br>
 <input type="text" name="accountTo"/> <br>
 Amount: <br>
 <input type="text" name="amount"/> <br>
 <input type="submit" name="ActionType" value="Transfer"/>
</form>
</div>

</div>


</body>
</html>