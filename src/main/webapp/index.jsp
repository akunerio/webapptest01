<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello world <%=new Date()%></title>
    </head>
    <body>
        <h1>Hello World! <%=new Date()%></h1>
        <%
            out.println("<br /> Your IP address is " + request.getRemoteAddr());
            String browser = request.getHeader("user-agent");
            out.print("<br /> and your browser is ");
            out.println(browser);
        %>
    </body>
</html>