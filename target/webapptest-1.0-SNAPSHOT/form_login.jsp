<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="auth">
            Username: <input type="text" name="user" /><br />
            Password: <input type="password" name="pass" /><br />
            <input type="submit" value="Login" />
        </form>
        ${pesan}
    </body>
</html>