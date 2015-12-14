<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 06/10/15
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Показать заказы</title>
</head>
<body>
<%String data= request.getParameter("login");
%>
<p><%=data%>, ты точно этого хочешь?</p><br/>
<form action="Sh" method="get">
  <input type="hidden" name="login" value="<%=data%>">
  <input type="submit" name="sub" value="Yes">
</form>
</body>
</html>
