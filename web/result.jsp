<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 06/10/15
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Показываем!</title>
</head>
<body>
<%Iterator itr;%>
<%Iterator itr2;%>
<% ArrayList<String> data= (ArrayList) request.getAttribute("data");
    ArrayList<Integer> id = (ArrayList) request.getAttribute("id");
    itr2 = id.iterator();
  for (itr=data.iterator(); itr.hasNext(); ) {
%>
<form action="DlUp" method="get">
<i><%=itr.next()%></i> <i><%=itr.next()%></i> <i><%=itr.next()%></i> <i><%=itr.next()%></i> <i><%=itr.next()%></i> <i><%=itr.next()%></i> <input type="submit" name="op" value="Delete"><input type="hidden" name="val" value="<%=itr2.next()%>"><br/>
    <input type="text" name="day" placeholder="day"><input type="text" name="month" placeholder="month"><input type="text" name="time" placeholder="time"><input type="submit" name="op" value="Update"><br/>
</form>
<%}%>
</body>
</html>
