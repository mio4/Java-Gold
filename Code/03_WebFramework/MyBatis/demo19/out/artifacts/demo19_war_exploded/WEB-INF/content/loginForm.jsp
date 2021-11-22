<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/30
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="login" method="post">
        <font color="red">${requestScope.message}</font>
        <table>
            <tr>
                <td>登录名：</td>
                <td><input type="text" id="loginname" name="loginname"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" id="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
