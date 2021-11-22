<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/3
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el demo1</title>
</head>
<body>
    <%
        request.setAttribute("requestKey","requestValue");
        session.setAttribute("sessionKey","sessionValue");
        application.setAttribute("applicationKey","applicationValue");
    %>

    获取request中的value：
    JSP表达式:<%=request.getAttribute("requestKey")%>
    EL表达式:${requestScope.get("requestKey")}
    <hr>

    获取session中的value：
    JSP表达式:<%=session.getAttribute("sessionKey")%>
    EL表达式:${sessionScope.get("sessionKey")}
    <hr>

    获取request中的value：
    JSP表达式:<%=application.getAttribute("applicationKey")%>
    EL表达式:${applicationScope.get("applicationKey")}
    <hr>

    获取失败时，返回值不同
    JSP： <%=application.getAttribute("a")%>
    EL：${applicationScope.get("a")}
    <hr>

    session域中的值：${sessionKey}

</body>
</html>
