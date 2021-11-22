<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/3
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL forEach</title>
</head>
<body>
    <c:forEach begin="1" end="20" step="1" var="i">
        ${i}
    </c:forEach>

    <hr>
    <c:forEach begin="1" end="20" step="2" var="i">
        ${i}
    </c:forEach>

    <hr>
    <c:forEach begin="1" end="20" step="1" var="i" varStatus="vs">
        ${i} -- ${vs.count} -- ${vs.current} <br/>
    </c:forEach>
</body>
</html>
