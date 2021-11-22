<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/4
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品展示页面</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <td>id</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>描述</td>
        </tr>
        <c:forEach items="${plist}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.pname}</td>
            <td>${p.price}</td>
            <td>${p.pdesc}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
