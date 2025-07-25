<%@ page language="java" %>
<%
    String username = request.getParameter("user");

    if (username == null || username.trim().isEmpty()) {
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>  <html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome, <%= username %>!</h2>
    <h2>Welcome to Home Page</h2>
    <p>This your Home page.</p>
    <a href="login.html">Logout</a>
</body>
</html>