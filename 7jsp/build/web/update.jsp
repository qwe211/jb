
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String name=request.getParameter("username");
            String pass=request.getParameter("oldpass");
            String npass=request.getParameter("newpass");
        %>
        <%
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Amaan#46");
                PreparedStatement st=(PreparedStatement) con.prepareStatement("update login set password=? where username=? && password=?");
                st.setString(1,npass);
                st.setString(2,name);
                st.setString(3,pass);
                int a=st.executeUpdate();
                if(a==1)
                {
                    %>
                    <h3>Update Successfull</h3>
                <% }
                else
                {
                    %><h3>Update unsuccessfull</h3>
                <% }
            }
            catch(Exception ex)
            {
                System.out.println(ex);;
            } %>
    </body>
</html>
