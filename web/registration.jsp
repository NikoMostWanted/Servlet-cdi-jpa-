<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 06/10/15
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="Reg" method="post">
  Введите имя<input type="text" name="name"><br/>
  Введите фамилию<input type="text" name="lastname"><br/>
  Введие логин<input type="text" name="login"><br/>
  Введите пароль<input type="password" name="password"><br/>
  <input type="submit" name="sub" value="Go">
</form>
</body>
</html>
