<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/25
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>图书主页</title>
</head>
<body>
    <h3>欢迎【${sessionScope.user.username}】</h3>
    <table border="1">
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
        </tr>
        <c:forEach items="${requestScope.bookList}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
