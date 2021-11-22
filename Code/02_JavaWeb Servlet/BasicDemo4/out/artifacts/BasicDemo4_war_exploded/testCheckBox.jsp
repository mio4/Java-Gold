<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/11
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>
    <h1>从复选框中读取数据</h1>
    <ul>
        <li><p><b>Google是否被选中： <%= request.getParameter("google")%></b></p></li>
        <li><p><b>淘宝是否被选中： <%= request.getParameter("taobao")%></b></p></li>
        <li><p><b>京东是否被选中： <%= request.getParameter("jingdong")%></b></p></li>
    </ul>
</body>
</html>
