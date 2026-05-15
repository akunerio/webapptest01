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
        <a href="products?action=add">Tambah Produk</a>
          <br/>
          <br/>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Nama</th>
                <th>Harga</th>
                <th colspan="2">Aksi</th>
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
                <th><a href="products?action=edit&id=<%= p.getId() %>">Edit</a></th>
                <th> 
                    <form method="post" action="products?action=del&id=<%= p.getId() %>"
                                style="display:inline" onsubmit="return confirm('Yakin hapus?')">
                        <button>Hapus</button>
                    </form>
                </th>
            </tr>
            <%  } %>
        </table>
        
    </body>
</html>