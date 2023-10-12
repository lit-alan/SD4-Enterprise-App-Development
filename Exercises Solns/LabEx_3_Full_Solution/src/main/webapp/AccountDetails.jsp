<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<LINK REL=STYLESHEET HREF="assets/css/style.css" TYPE="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drill Down ${account.accountNumber}</title>
    </head>
    <body>

        <table  width='350' >
            <tr><td>Account ID</td><td>${account.accountNumber}</td>  </TR>
            <tr><td>First Name</td><td>${account.firstName}</td>  </TR>
            <tr><td>Last Name</td><td>${account.lastName}</td></TR>
            <tr><td>Sort Code</td><td>${account.sortCode}</td></TR>
            <tr><td>Current Balance</td><td><fmt:formatNumber value="${account.balance}" type="currency" currencySymbol="&euro;" maxFractionDigits="2"/> </td></TR>

        </table>
        <hr>
        <form name="AdjustBalance" action="AdjustBalance" method="post">
            <table  width='350' >
                <tr>
                    <td><label>Enter Amount</label></td> <td><input type="number" name="adjustmentAmt" min="1" step="any" /> </td>
                    <td><label>Debit</label></td>        <td><input type="radio" id="operation" name="operation" value="debit"></td>
                    <td><label>Credit</label></td>       <td><input type="radio" id="operation" name="operation" value="credit"></td>
            <table>
                <input type="submit" value="Adjust Balance"/>
        </form>
        <br><br><br>
        <a href="index.jsp">Home</a>
     </body>
</html>
