
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
    </head>
    <body>
                <% 
            String name=request.getParameter("username");
            String pass=request.getParameter("password");
        %>
        <%
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Amaan#46");
                PreparedStatement st=(PreparedStatement) con.prepareStatement("delete from login where username=?,password=?");
                st.setString(1,name);
                st.setString(2,pass);
                int a=st.executeUpdate();
                if(a==1)
                {
                    %>
                    <h3>Record Deleted</h3>
                <% }
                else
                {
                    %><h3>Record Not Deleted</h3>
                <% }
            }
            catch(Exception ex)
            {
                System.out.println(ex);;
            } %>
    </body>
</html>
