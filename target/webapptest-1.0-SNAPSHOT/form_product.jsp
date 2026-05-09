<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h3>${title}</h3>
        <jsp:useBean id="product" scope="request" type="models.Product"></jsp:useBean>
        <form method="post" action="product?action=u">
            Nama &nbsp; : <input type="text" name="nama"
                                value="<jsp:getProperty name="product" property="name" />" />
            <br />
            Harga &nbsp; : <input type="number" name="harga"
                                value="<jsp:getProperty name="product" property="price" />" />
            <br /><br />
            <input type="submit" value="Simpan" />
        </form>
    </body>
</html>