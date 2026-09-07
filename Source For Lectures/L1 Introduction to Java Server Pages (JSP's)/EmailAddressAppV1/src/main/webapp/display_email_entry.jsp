
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        %>
       
        <h1> Thanks for joining our email list </h1>
        
        <p> Here is the information you entered: </p>

        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td align="right"> First name: </td>
                <td><%= firstName %> </td>
            </tr>         
            <tr>
                <td align="right"> Last name: </td>
                <td><%= lastName %> </td>
            </tr>
            
            <tr>
                <td align="right"> Email address: </td>
                <td><%= emailAddress %> </td>
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
