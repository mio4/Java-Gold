<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/11
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" isErrorPage="false" errorPage="600.jsp"%>
<html>
<head>
    <title>测试session属性</title>
</head>
<body>
<%
    session.setAttribute("skey","svalue");
    int i = 1/0;
%>

<%= session.getAttribute("skey")%>
${sessionScope.skey}
</body>
</html>
