<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    
	HttpSession sess = request.getSession(false);
    String user = (sess != null) ? (String) sess.getAttribute("user") : null;
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Home - TestApp</title>
</head>
<body>
    <h2>Welcome, <%= user %>!</h2>
    <a href="logout.jsp">Logout</a>
</body>
</html>