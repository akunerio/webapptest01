<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Product "%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h4>Form ${title}</h4>
        <%
            Product prod = null;
            if (request.getAttribute("product") != null) prod = (Product) request.getAttribute("product");
        %>
        <form class="border" style="padding:20px" method="POST" action="products${action}">
            <div>
                <label>Nama</label>
                <input type="text" name="name" class="form-control" value="<%= prod == null ? "" : prod.getName() %>" required />
            </div>
            <div>
                <label>Harga</label>
                <input type="number" name="price" class="form-control" value="<%= prod == null ? "" : prod.getPrice() %>" required />
            </div>
            <div>
                <button class="btn btn-success">Simpan</button>
            </div>
        </form>
    </body>
</html>