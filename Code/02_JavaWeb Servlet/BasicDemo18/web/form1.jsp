<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/16
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload1" method="post" enctype="multipart/form-data">
        用户名： <input name="username"><br/>
        上传图片：<input type="file" name="file"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
