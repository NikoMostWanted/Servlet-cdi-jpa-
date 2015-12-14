<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 06/10/15
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Меню</title>
</head>
<body>
    <%String data= request.getParameter("login");
        String id_user = request.getParameter("id_user");

    %>
<p>Привет <%=data%></p><br/>
<form action="Act" method="get">
    <input type="hidden" name="login" value="<%=data%>"><br/>
    <input type="submit" name="action" value="Create"><br/>
    <input type="submit" name="action" value="Show"><br/>
</form>
</body>
</html>
