<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<!DOCTYPE html>
<html>
    <head>
        <LINK REL=STYLESHEET HREF="assets/css/style.css" TYPE="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="getAccountByID" action="ShowBalance">
            
            Enter Account ID <input type="text" name="id" value="" /> <input type="submit" value="Get Account" name="btn1" />
        </form>
         <form name="getAllAccounts" action="ShowAllAccounts">
             <br><br> 
           <input type="submit" value="Get All Accounts" name="btn2" />
           <br>
        </form>


        <c:if test="${fn:length(cookie) gt 1}">


            <h3>Previous Accounts You have searched for</h3>
            <c:set value="JSESSIONID" var="jsess"/>

            <c:forEach items="${cookie}" var="currentCookie">
                <c:if test = "${currentCookie.value.name.equals(jsess)}">
                        <!-- do nothing -->
                </c:if>
                <c:if test = "${!currentCookie.value.name.equals(jsess)}">
                    <li> <a href="AccountDrillDown?id=${currentCookie.value.name}">${currentCookie.value.value}</a> </li>
                </c:if>

            </c:forEach>
        </c:if>
    </body>
</html>
