<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/24
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
    <%--是否可以直接通过.username的方式访问对象的属性--%>
    访问request域中的user对象：${requestScope.user.username}
    访问request域中的user对象：${requestScope.user}
</body>
</html>
