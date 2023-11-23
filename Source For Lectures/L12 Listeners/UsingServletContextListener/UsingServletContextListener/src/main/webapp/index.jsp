<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h1>Product List</h1>

<table cellpadding="5" border=1>

    <tr valign="bottom">
        <td align="left"><b>Description</b></td>
        <td align="left"><b>Price</b></td>
    </tr>

    <c:forEach var="product" items="${products}">
        <tr valign="top">
            <td>${product.description}</td>
            <td> <fmt:formatNumber value = "${product.price}" type = "currency" currencySymbol="&euro;"/> </td>
        </tr>
    </c:forEach>

</table>

<p>
    For customer service, please send an email to ${custServEmail}.
</p>

<p>
    &copy; Copyright ${currentYear} Alan Ryan Inc.
    All rights reserved.
</p>

</body>
</html>