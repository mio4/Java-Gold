<%@ page import="com.mio4.web.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/12
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>将User添加到Sesion域</title>
</head>
<body>
    <%
        session.setAttribute("user", new User(20,"mio"));
    %>
</body>
</html>
