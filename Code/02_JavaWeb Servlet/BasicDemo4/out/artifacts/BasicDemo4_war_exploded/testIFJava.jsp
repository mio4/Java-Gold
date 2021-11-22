<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/10
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int day = 1;%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    if(day == 1 || day == 2)
    	out.println("今天是周一、周二");
    else
    	out.println("me");
%>

</body>
</html>
