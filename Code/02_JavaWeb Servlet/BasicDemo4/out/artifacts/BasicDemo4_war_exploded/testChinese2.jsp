<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/11
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>测试是否产生中文乱码</title>
</head>
<body>
    <form action="<%= request.getContextPath()%>/servlet/RequestDemo04" method="post">
        用户名：<input type="text" name="userName">
        <input type="submit" value="post方式提交表单">
    </form>
</body>
</html>
