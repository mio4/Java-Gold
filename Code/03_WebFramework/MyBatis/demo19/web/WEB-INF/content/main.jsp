<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/30
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍页面</title>
</head>
<body>
    欢迎【${sessionScope.user.username}】访问
    <table border="1">
        <tr>
            <th>封面</th>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
        </tr>
        <c:forEach items="${requestScope.book_list}" var="book">
            <td>${book.image}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
        </c:forEach>
    </table>
</body>
</html>
