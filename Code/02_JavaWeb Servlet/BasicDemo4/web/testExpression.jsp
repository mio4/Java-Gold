<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/10
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSP中的表达式</title>
</head>
<body>
<p>
    <%--这部分不会在网页中显示出来 --%>
    <!--这是HTML文本的注释 -->
    今天的日期是<%= (new java.util.Date()).toString()%>
</p>
</body>
</html>
