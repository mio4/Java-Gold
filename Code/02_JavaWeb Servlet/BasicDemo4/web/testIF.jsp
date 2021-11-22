<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/10
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int day=3;%>
<html>
<head>
    <title>测试if-else语句</title>
</head>
<body>
<% if(day==1 || day==7) {%>
    <p>今天是周一、周末</p>
<% } else {%>
<p>今天不是周一、周末</p>
<% } %>

</body>
</html>
