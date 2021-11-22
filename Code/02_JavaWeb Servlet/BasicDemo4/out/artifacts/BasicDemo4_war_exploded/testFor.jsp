<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/10
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int fontSize; %>
<html>
<head>
    <title>测试For循环语句</title>
</head>
<body>
<h3>For循环实例</h3>
<%for (fontSize=1; fontSize < 25; fontSize++) {%>
    <font color="red" size="<%= fontSize%>">
        尝试font
    </font>
<%}%>
</body>
</html>
