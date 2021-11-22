<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/11
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="uft-8"/>
    <title>JSP POST方法</title>
</head>
<body>
<h1>使用POST方法读取数据</h1>
<ul>
    <li>
        <p><b>站点名：</b>
        <% String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8"); %>
        <%= name%>
    </p></li>
    <li><p>
        <b>网址：</b><%= request.getParameter("url")%>
    </p></li>
</ul>
</body>
</html>
