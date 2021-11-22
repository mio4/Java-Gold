<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/12
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>将User从Sesion中移除</title>
</head>
<body>
    <%
        session.removeAttribute("user");
    %>
</body>
</html>
