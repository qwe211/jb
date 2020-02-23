
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
    </head>
    <body>
       <%
            String n=request.getParameter("username");
            String p=request.getParameter("password");
        %>
        <% try{ 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Amaan#46"); 
        PreparedStatement st=(PreparedStatement) con.prepareStatement("select username,password from login where username=?,password=?"); 
        st.setString(1,n);
        st.setString(2,p);
        ResultSet rs=st.executeQuery(); 
        if(rs.next()){ %>
        <h3>Login Successful</h3>
         <%} 
         else{ %>
        <h3>Login Unsuccessful</h3>
        <% } 
         } 
         catch(Exception ex){ 
            out.println(ex.toString());
          } %> 
    </body>
</html>
