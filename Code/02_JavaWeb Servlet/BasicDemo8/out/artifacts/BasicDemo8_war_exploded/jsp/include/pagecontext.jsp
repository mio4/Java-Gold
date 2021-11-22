<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/3
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过pageContext操作其他的域对象</title>
</head>
<body>
    <%
        pageContext.setAttribute("rkey","rvalue",PageContext.REQUEST_SCOPE);
        session.setAttribute("rkey","session value");
    %>

    获取pageContext中的value:
    <%= request.getAttribute("rkey")%>
    <hr>
    获取session中的value:
    <%= session.getAttribute("rkey")%>
    <hr>
    便捷查找
    <%= pageContext.findAttribute("rkey")%>
    <hr>
    <%= pageContext.findAttribute("akey")%>
</body>
</html>
