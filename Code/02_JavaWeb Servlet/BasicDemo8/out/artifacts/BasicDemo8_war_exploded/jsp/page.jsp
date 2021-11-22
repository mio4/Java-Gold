<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/2
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="600.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% session.setAttribute("skey","svalue");
        int i = 1/0;
    %>
    <%= session.getAttribute("skey")%>
    ${sessionScope.skey}
</body>
</html>
