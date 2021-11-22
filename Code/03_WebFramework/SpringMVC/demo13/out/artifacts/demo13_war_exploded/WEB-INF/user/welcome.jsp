<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/23
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
    ${requestScope.user.username}<br>
    ${sessionScope.user.username}<br>
</body>
</html>
