<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/10
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="8kb" autoFlush="true" session="true" pageEncoding="UTF-8" %>
<html>
<head>
    <title>This is my test jsp </title>
</head>
<body>
Hello World!<br/>
<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>
</body>
</html>
