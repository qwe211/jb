<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Login Page</title>
    </head>
    <body>
        <%
            String uname=request.getParameter("username");
            String pass=request.getParameter("password");
            if(uname.equals("john") && pass.equals("786"))
            {
                %><h3>Login Successful</h3>
        <%    }
            else
            {
                %> <h3>Login Unsuccessful</h3>
        <%    } %>
    </body>
</html>
