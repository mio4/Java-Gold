<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/23
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
    <%--等价于request.getAttribute(message)--%>
    这是一个从HelloController传来的数据：<br>
    ${requestScope.message}
</body>
</html>
