

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="check" method="post">
        <label>Username</label>
        <input type="text" name="name" placeholder="Username" required><br><br>
        <label>Password</label>
        <input type="password" name="pass" placeholder="Password" required><br><br>&nbsp;
        <input type="submit" value="Login">
        </form>
    </body>
</html>
