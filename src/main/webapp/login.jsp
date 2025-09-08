<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - TestApp</title>
</head>
<body>
    <h2>Login Page</h2>
    <form method="post" action="login">
        Username: <input type="text" name="username" /> <br/><br/>
        Password: <input type="password" name="password" /> <br/><br/>
        <input type="submit" value="Login" />
    </form>
    <p style="color:red;">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </p>
</body>
</html>