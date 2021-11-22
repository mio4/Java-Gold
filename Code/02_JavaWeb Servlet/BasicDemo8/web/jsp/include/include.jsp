<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/2
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Include指令</title>
</head>
<body>
    page include
    <hr>
        page 1内容：<%@ include file="/jsp/include/page1.jsp" %>
    <hr>
        page 2内容：<%@ include file="page2.jsp" %>
</body>
</html>
