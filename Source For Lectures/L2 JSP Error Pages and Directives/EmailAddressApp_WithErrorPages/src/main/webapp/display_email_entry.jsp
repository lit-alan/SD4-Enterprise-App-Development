<%@ page import="business.User" %>
<%@ page import="data.UserIO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "emailAddressAppError.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Address App</title>
    </head>
    <body>

        
        <%
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String ageInput = request.getParameter("age");
        
        int age = Integer.parseInt(ageInput);
        
       
        ServletContext sc = this.getServletContext();
        
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        
        User user = new User(firstName, lastName, emailAddress,age);
        
        UserIO.add(user, path);
        
        %>
       
        <h1> Thanks for joining our email list </h1>
        
        <p> Here is the information you entered: </p>

        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td align="right"> First name: </td>
                <td><%= user.getFirstName()%> </td>
            </tr>         
            <tr>
                <td align="right"> Last name: </td>
                <td><%= user.getLastName()%> </td>
            </tr>
            
            <tr>
                <td align="right"> Email address: </td>
                <td><%= user.getEmailAddress() %> </td>
            </tr>
             <tr>
                <td align="right"> Age:</td>
                <td><%= user.getAge() %> </td>
            </tr>
        </table>

        <p>To enter another email address, click on the Back <br>
           button in your browser or the Return button shown <br>
           below. </p>
            
        <form action="join_email_list.html" method="post">
            <input type="submit" value="Return">
        </form>






    </body>
    
    
</html>
