<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/11
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.io.*,java.util.*"%>
<html>
<head>
    <title>测试表单数据的读入</title>
</head>
<body>
<h1>使用GET方法读取数据</h1>
<ul>
    <li><p><b>站点名称:</b>
        <%= request.getParameter("name")%></p>
    </li>

    <li><p><b>网址：
    <%= request.getParameter("url")%></b></p>
    </li>
</ul>
</body>
</html>
