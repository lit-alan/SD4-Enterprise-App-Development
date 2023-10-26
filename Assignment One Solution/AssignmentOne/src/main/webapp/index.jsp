<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/style.css">
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>

</head>
<body>
<div class="container">
    <h1>All Customers</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>City</th>
            <th>Country</th>
            <th>Post Code</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
        <tr>
            <td><a href="GetCustomerByID?id=${customer.customerId}">${customer.customerId}</a></td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>${customer.city}</td>
                <td>${customer.country}</td>
                <td>${customer.postcode}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
