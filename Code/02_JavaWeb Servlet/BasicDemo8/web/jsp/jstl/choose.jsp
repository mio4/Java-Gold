<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/4
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title> jstl choose </title>
</head>
<body>
    <c:set var="day" value="3"/> <!--相当于pageContext.setAttribute("day","3")-->
    <c:choose>
        <c:when test="${day==1}">
            周1
        </c:when>
        <c:when test="${day==3}">
            周3
        </c:when>
    </c:choose>
</body>
</html>
