<%@ page import="com.mio4.web.User" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/3
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaBean</title>
</head>
<body>
    <%
        User user = new User();
        user.setId(1);
        user.setName("mio");
        user.setPassword("123456");
        request.setAttribute("user",user);
    %>

    获取user <hr>
    JSP表达式获取id：<%= ((User)request.getAttribute("user")).getId()%> <hr>
    EL表达式获取id：${user.id}
</body>
</html>
