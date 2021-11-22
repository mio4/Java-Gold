<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/12
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session生命周期</title>
</head>
<body>
    <%
        session.invalidate();
    %>
    session已销毁
</body>
</html>
