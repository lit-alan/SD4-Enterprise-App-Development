<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" href="assets/style.css">
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>

</head>
<body>
<div class="container">
    <h1>Customer ${customer.customerId}</h1>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Reviews</th>
        </tr>
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>
                <c:forEach var="review" items="${customer.reviewList}">
                    <c:if test="${review.rating >= 3}">
                        <li class="review-item">
                            <strong>Rating:</strong> ${review.rating}
                            <strong>Comment:</strong> ${review.comment}
                            <strong>Product:</strong> ${review.product.name}
                            <strong>Price:</strong>   <fmt:formatNumber value="${review.product.price}" type="currency" currencySymbol="€" />
                        </li>
                    </c:if>
                </c:forEach>
                <strong>Avg Rating:</strong> ${reviewAvg}
            </td>
        </tr>
    </table>
    <p><a href="javascript:history.back()">Go Back</a></p>
</div>
</body>
</html>
