<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 06/10/15
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать заказ</title>
</head>
<body>
<%String data= request.getParameter("login");
%>
<form action="Cre" method="get">
  <input type="hidden" name="login" value="<%=data%>">
  Какую машину вы хотите<input type="text" name="car"><br/>
  Введите день<input type="text" name="day"><br/>
  Введите месяц<input type="text" name="month"><br/>
  Введите время<input type="text" name="time"><br/>
  <input type="submit" name="sub" value="Go">
</form>
</body>
</html>
