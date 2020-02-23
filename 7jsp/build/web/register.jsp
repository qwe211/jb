
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <% 
            String name=request.getParameter("name");
            String age=request.getParameter("age");
            int age1=Integer.parseInt(age);
            String emailid=request.getParameter("emailid");
            String addr=request.getParameter("addr");
            String pno=request.getParameter("pno");
            
        %>
        <%
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Amaan#46");
                PreparedStatement st=(PreparedStatement) con.prepareStatement("insert into registra values(?,?,?,?,?)");
                st.setString(1,name);
                st.setInt(2,age1);
                st.setString(3,emailid);
                st.setString(4,addr);
                st.setString(5,pno);
                int a=st.executeUpdate();
                if(a==1)
                {
                    %>
                    <h3>Registration Successfull</h3>
                <% }
                else
                {
                    %><h3>Registration Unsuccessfull</h3>
                <% }
            }
            catch(Exception ex)
            {
                System.out.println(ex);;
            } %>
    </body>
</html>
