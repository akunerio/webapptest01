<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, models.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        <%
            ArrayList<ArrayList<Object>> prods = (ArrayList<ArrayList<Object>>) request.getAttribute("list");
            ArrayList<Object> p = prods.get(0);
        %>
        <h2>Jumlah produk : <%= p.get(0) %></h2>
        <h2>Rata-rata harga : <%= String.format("%.1f", p.get(1)) %></h2>
    </body>
</html>