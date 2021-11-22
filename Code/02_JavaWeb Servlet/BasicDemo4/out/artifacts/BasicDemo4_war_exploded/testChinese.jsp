<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/10
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>只是一个中文页面</title>
</head>
<body>
<%
    out.println("你的IP地址是：" + request.getRemoteAddr());
%>
</body>
</html>
