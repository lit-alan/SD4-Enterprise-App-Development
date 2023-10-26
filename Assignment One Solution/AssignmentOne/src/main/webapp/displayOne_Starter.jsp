<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/style.css">
<!DOCTYPE html>
<html>
<head>
    <title>Customer Drill Down</title>

</head>
<body>
<div class="container">
    <h1>Customer Number XXX</h1>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Reviews</th>
        </tr>
        <tr>
            <td>Michael</td>
            <td>Clarke</td>
            <td>mc@gmail.com</td>
            <td>123 Fake Street</td>
            <td>
                    <li class="review-item">
                        <strong>Rating:</strong> 3
                        <strong>Comment:</strong> Trixy never took to it
                        <strong>Product:</strong> Carrier purse
                        <strong>Price:</strong> €9.99
                    </li>
                    <li class="review-item">
                        <strong>Rating:</strong> 5
                        <strong>Comment:</strong> My fish nearly choked on them
                        <strong>Product:</strong> Sunglasses
                        <strong>Price:</strong> €79.99
                    </li>
                <strong>Avg Rating:</strong> 4
            </td>

        </tr>

    </table>
    <p><a href="javascript:history.back()">Go Back</a></p>
</div>
</body>
</html>
