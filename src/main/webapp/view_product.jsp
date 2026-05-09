<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, models.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h3>${title}</h3>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Nama</th>
                <th>Harga</th>
            </tr>
            <%
                ArrayList<Product> prods = (ArrayList<Product>)request.getAttribute("list");
                int i = 1;
                for (Product p : prods) {
            %>
            <tr>
                <th><%= i++ %></th>
                <th><%= p.getName() %></th>
                <th><%= p.getPrice() %></th>
            </tr>
            <%  } %>
        </table>
    </body>
</html>